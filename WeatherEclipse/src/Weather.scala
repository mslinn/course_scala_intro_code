case class Weather(var status: String)

object Main extends App {
  implicit class RichWeather(weather: Weather) {
    def genericOp(newStatus: String): Weather = {
      weather.status = newStatus
      println(s"It is now ${weather.status}")
      weather
    }

    def rain(): Weather = genericOp("raining")

    def hail(): Weather = genericOp("hailing")

    def sunshine(): Weather = genericOp("shining")
  }

  val weather = Weather("shining")
  weather.rain()
  weather.hail()
  weather.sunshine()
}
