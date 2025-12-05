//> using scala 3.7.3
//> using platform scala-js
//> using dep "org.scala-js::scalajs-dom::2.8.1"
//> using dep "com.raquo::laminar::17.2.1"
//> using jsModuleKind es

import org.scalajs.dom
import com.raquo.laminar.api.L.*
import com.raquo.laminar.api.L
import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

// CSS imports
@js.native
@JSImport("./src/style.css", JSImport.Namespace)
object StyleCSS extends js.Object

@js.native
@JSImport("./src/tabulator.css", JSImport.Namespace)
object TabulatorCSS extends js.Object

// Tabulator import
@js.native
@JSImport("./src/tabulator/core/TabulatorFull.js", JSImport.Default)
class Tabulator(element: String, options: js.Object) extends js.Object

// Column definition trait
trait ColumnDef extends js.Object {
  val title: String
  val field: String
  val sorter: String
}

// Row data trait
trait RowData extends js.Object {
  val id: Int
  val name: String
  val age: Int
  val gender: String
}

// Tabulator options trait
trait TabulatorOptions extends js.Object {
  val data: js.Array[RowData]
  val columns: js.Array[ColumnDef]
  val layout: String
}

def initializeApp(): Unit = {
  // Force CSS imports to be included
  val _ = (StyleCSS, TabulatorCSS)

  // Test data
  val testData: js.Array[RowData] = js.Array(
    js.Dynamic
      .literal(id = 1, name = "Alice", age = 25, gender = "Female")
      .asInstanceOf[RowData],
    js.Dynamic
      .literal(id = 2, name = "Bob", age = 32, gender = "Male")
      .asInstanceOf[RowData],
    js.Dynamic
      .literal(id = 3, name = "Charlie", age = 45, gender = "Male")
      .asInstanceOf[RowData],
    js.Dynamic
      .literal(id = 4, name = "Diana", age = 27, gender = "Female")
      .asInstanceOf[RowData],
    js.Dynamic
      .literal(id = 5, name = "Ethan", age = 35, gender = "Male")
      .asInstanceOf[RowData]
  )

  // Column definitions
  val columns: js.Array[ColumnDef] = js.Array(
    js.Dynamic
      .literal(title = "ID", field = "id", sorter = "number")
      .asInstanceOf[ColumnDef],
    js.Dynamic
      .literal(title = "Name", field = "name", sorter = "string")
      .asInstanceOf[ColumnDef],
    js.Dynamic
      .literal(title = "Age", field = "age", sorter = "number")
      .asInstanceOf[ColumnDef],
    js.Dynamic
      .literal(title = "Gender", field = "gender", sorter = "string")
      .asInstanceOf[ColumnDef]
  )

  // Initialize Tabulator table directly in #app
  val options = js.Dynamic.literal(
    data = testData,
    columns = columns,
    layout = "fitColumns"
  )

  val table = new Tabulator("#app", options.asInstanceOf[js.Object])

  // Make table globally available for testing/debugging
  js.Dynamic.global.testTable = table
}
class MyClass {
  // var rootNode: L.RootNode =
  //   scala.compiletime.uninitialized
}

@main
def run(): Unit = {
  val x = MyClass()
  println(x)
  // Initialize when DOM is ready
  // val x = Option(1).orNull
  if (dom.document.readyState == "loading") {
    dom.document.addEventListener(
      "DOMContentLoaded",
      (_: dom.Event) => initializeApp()
    )
  } else {
    initializeApp()
  }
}
