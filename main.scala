//> using scala 3.7.3
//> using platform scala-js
//> using dep "org.scala-js::scalajs-dom::2.8.1"
//> using dep "com.raquo::laminar::17.2.1"
//> using jsModuleKind es

import org.scalajs.dom
import com.raquo.laminar.api.L.*
import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@main
def run(): Unit = {
  val container = dom.document.getElementById("app")
  render(container, div("hello"))
}
