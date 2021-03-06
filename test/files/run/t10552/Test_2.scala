import scala.tools.partest._

object Test extends DirectTest {
  override def extraSettings: String = "-usejavacp -Ystop-after:typer"

  def code = "class C { A.f }"

  def show(): Unit = try {
    compile()
    throw new Error("Expected OutOfMemoryError")
  } catch {
    case e: OutOfMemoryError if e.getMessage == "OOM" =>
  }
}
