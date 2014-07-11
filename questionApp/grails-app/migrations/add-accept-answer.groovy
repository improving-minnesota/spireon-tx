databaseChangeLog = {

	changeSet(author: "Doug (generated)", id: "1405095843386-1") {
		addColumn(tableName: "answer") {
			column(name: "accepted", type: "boolean") {
				constraints(nullable: "false")
			}
		}
	}
}
