databaseChangeLog = {

	changeSet(author: "Doug (generated)", id: "1405095737845-1") {
		createTable(tableName: "ANSWER") {
			column(autoIncrement: "true", name: "ID", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "CONSTRAINT_7")
			}

			column(name: "VERSION", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "AUTHOR_ID", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "DATE_CREATED", type: "TIMESTAMP") {
				constraints(nullable: "false")
			}

			column(name: "LAST_UPDATED", type: "TIMESTAMP") {
				constraints(nullable: "false")
			}

			column(name: "QUESTION_ID", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "TEXT", type: "VARCHAR(10000)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Doug (generated)", id: "1405095737845-2") {
		createTable(tableName: "TOPICS") {
			column(autoIncrement: "true", name: "ID", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "CONSTRAINT_9")
			}

			column(name: "VERSION", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "DATE_CREATED", type: "TIMESTAMP") {
				constraints(nullable: "false")
			}

			column(name: "DELETED", type: "BOOLEAN") {
				constraints(nullable: "false")
			}

			column(name: "LAST_UPDATED", type: "TIMESTAMP") {
				constraints(nullable: "false")
			}

			column(name: "TEXT", type: "VARCHAR(10000)") {
				constraints(nullable: "false")
			}

			column(name: "TITLE", type: "VARCHAR(200)") {
				constraints(nullable: "false")
			}

			column(name: "USER_ID", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Doug (generated)", id: "1405095737845-3") {
		createTable(tableName: "USER") {
			column(autoIncrement: "true", name: "ID", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "CONSTRAINT_2")
			}

			column(name: "VERSION", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "DATE_CREATED", type: "TIMESTAMP") {
				constraints(nullable: "false")
			}

			column(name: "EMAIL", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "FIRST_NAME", type: "VARCHAR(30)") {
				constraints(nullable: "false")
			}

			column(name: "LAST_NAME", type: "VARCHAR(30)") {
				constraints(nullable: "false")
			}

			column(name: "LAST_UPDATED", type: "TIMESTAMP") {
				constraints(nullable: "false")
			}

			column(name: "USERNAME", type: "VARCHAR(30)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Doug (generated)", id: "1405095737845-7") {
		createIndex(indexName: "UK_SB8BBOUER5WAK8VYIIY4PF2BX_INDEX_2", tableName: "USER", unique: "true") {
			column(name: "USERNAME")
		}
	}

	changeSet(author: "Doug (generated)", id: "1405095737845-8") {
		createIndex(indexName: "USERNAME_IDX", tableName: "USER", unique: "false") {
			column(name: "USERNAME")
		}
	}

	changeSet(author: "Doug (generated)", id: "1405095737845-4") {
		addForeignKeyConstraint(baseColumnNames: "AUTHOR_ID", baseTableName: "ANSWER", baseTableSchemaName: "PUBLIC", constraintName: "FK_JWGBF0AJNQ10U13V3JR2E5S88", deferrable: "false", initiallyDeferred: "false", onDelete: "RESTRICT", onUpdate: "RESTRICT", referencedColumnNames: "ID", referencedTableName: "USER", referencedTableSchemaName: "PUBLIC", referencesUniqueColumn: "false")
	}

	changeSet(author: "Doug (generated)", id: "1405095737845-5") {
		addForeignKeyConstraint(baseColumnNames: "QUESTION_ID", baseTableName: "ANSWER", baseTableSchemaName: "PUBLIC", constraintName: "FK_EIX9DU6U2R4WXWU415WQ8YB99", deferrable: "false", initiallyDeferred: "false", onDelete: "RESTRICT", onUpdate: "RESTRICT", referencedColumnNames: "ID", referencedTableName: "TOPICS", referencedTableSchemaName: "PUBLIC", referencesUniqueColumn: "false")
	}

	changeSet(author: "Doug (generated)", id: "1405095737845-6") {
		addForeignKeyConstraint(baseColumnNames: "USER_ID", baseTableName: "TOPICS", baseTableSchemaName: "PUBLIC", constraintName: "FK_3XWO6YG0XH1FC5I2ILCF6VBD7", deferrable: "false", initiallyDeferred: "false", onDelete: "RESTRICT", onUpdate: "RESTRICT", referencedColumnNames: "ID", referencedTableName: "USER", referencedTableSchemaName: "PUBLIC", referencesUniqueColumn: "false")
	}

	include file: 'add-accept-answer.groovy'
}
