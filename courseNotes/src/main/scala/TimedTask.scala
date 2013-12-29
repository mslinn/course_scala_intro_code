object TimedTask {
  import java.util.{Timer, TimerTask}

  def apply(intervalSeconds: Int=1)(op: => Unit) {
    val task = new TimerTask {
      def run = op
    }
    val timer = new Timer
    timer.schedule(task, 0L, intervalSeconds*1000L)
  }
}

object TimedDemo extends App {
  import java.util.Date

  TimedTask(1)(println(s"Hello, world! ${new Date}"))
}