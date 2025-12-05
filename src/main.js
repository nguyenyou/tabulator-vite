import './style.css'
import "./tabulator.css"
import Tabulator from './tabulator/core/TabulatorFull.js'

// Initialize the app
function initializeApp() {
	// Test data
	const testData = [
		{ id: 1, name: "Alice", age: 25, gender: "Female" },
		{ id: 2, name: "Bob", age: 32, gender: "Male" },
		{ id: 3, name: "Charlie", age: 45, gender: "Male" },
		{ id: 4, name: "Diana", age: 27, gender: "Female" },
		{ id: 5, name: "Ethan", age: 35, gender: "Male" },
	];

	// Column definitions
	const columns = [
		{ title: "ID", field: "id", sorter: "number" },
		{ title: "Name", field: "name", sorter: "string" },
		{ title: "Age", field: "age", sorter: "number" },
		{ title: "Gender", field: "gender", sorter: "string" },
	];

	// Initialize Tabulator table directly in #app
	const table = new Tabulator("#app", {
		data: testData,
		columns: columns,
		layout: "fitColumns",
	});
}

// Initialize when DOM is ready
if (document.readyState === 'loading') {
	document.addEventListener('DOMContentLoaded', initializeApp);
} else {
	initializeApp();
}
