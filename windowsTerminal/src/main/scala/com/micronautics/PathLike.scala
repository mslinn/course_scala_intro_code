package com.micronautics

import java.nio.file.{Path, Paths}
import scala.collection.mutable

object PathLike {
  implicit class RichPath(path: Path) extends PathLike {
    @inline def baseName: Path = baseName(path)
    @inline def cd: Path = cd(path)
    @inline override def cwd: Path = super.cwd
    @inline def dirName: Path = dirName(path)
    @inline def exists: Boolean = exists(path)
    @inline def toFile: java.io.File = path.toFile
    @inline def isDirectory: Boolean = toFile.isDirectory
    @inline def fileType: String = fileType(path)
    @inline def fileNameOnly: String = fileNameOnly(path)
    @inline override def popd(errorIsFatal: Boolean=true): Path = super.popd(errorIsFatal)
    @inline def pushd: Path = pushd(path)
    @inline override def topd: Option[Path] = super.topd
  }
}

trait PathLike {
  val home: Path = Paths.get(System.getProperty("user.home"))
  var verbose: Boolean = false

  protected val upsideDownStack: mutable.Buffer[Path] = mutable.Buffer.empty

  @inline def baseName(path: Path): Path = path.getFileName

  @inline def baseName(pathStr: String): Path = Paths.get(pathStr).getFileName

  @inline def cd(path: Path): Path = {
    System.setProperty("user.dir", path.toAbsolutePath.toString)
    if (verbose) info(s"push($path)")
    path
  }

  @inline def cwd: Path = Paths.get(System.getProperty("user.dir"))

  @inline def dirName(path: Path): Path = path.getParent

  @inline def dirName(pathStr: String): Path = Paths.get(pathStr).getParent

  @inline def exists(path: Path): Boolean = path.toFile.exists

  @inline def toFile(path: Path): java.io.File = path.toFile

  @inline def isDirectory(path: Path): Boolean = path.toFile.isDirectory

  @inline def isEmpty: Boolean = upsideDownStack.isEmpty

  @inline def fileNameOnly(path: Path): String = {
    val fileName: String = path.getFileName.toString
    fileName.substring(0, fileName.lastIndexOf("."))
  }

  @inline def fileType(path: Path): String = {
    val fileName = baseName(path).getFileName.toString
    fileName.substring(fileName.lastIndexOf(".") + 1)
  }

  @inline def nonEmpty: Boolean = upsideDownStack.nonEmpty

  @inline def popd(errorIsFatal: Boolean=true): Path = if (upsideDownStack.nonEmpty) {
    if (verbose) info(s"pop; $topd=${ topd.mkString }")
    upsideDownStack.remove(upsideDownStack.size-1)
  } else {
    if (errorIsFatal)
      die(42, "PathHelper stack is empty but pop was called.")
    else {
      info("PathHelper stack is empty but pop was called.")
      cwd
    }
  }

  @inline def pushd(path: Path): Path = {
    upsideDownStack.append(cwd)
    cd(path)
  }

  @inline def pushd(pathStr: String): Path = pushd(Paths.get(pathStr))

  /** Does not modify upsideDownStack */
  @inline def topd: Option[Path] = upsideDownStack.lastOption
}
