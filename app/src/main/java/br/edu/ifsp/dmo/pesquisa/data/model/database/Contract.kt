package br.edu.ifsp.dmo.pesquisa.data.model.database

import android.provider.BaseColumns

object Contract {
    object Database {
        const val DATABASE_NAME = "opinion_survey"
        const val DATABASE_VERSION = 5
    }

    object Student : BaseColumns {
        const val TABLE_NAME = "students"
        const val COLUMN_ID = "student_id"
        const val COLUMN_FULL_NAME = "full_name"
        const val COLUMN_VOTED = "voted"

        const val SQL_CREATE = """
            CREATE TABLE ${TABLE_NAME} (
                ${COLUMN_ID} VARCHAR(20) PRIMARY KEY,
                ${COLUMN_FULL_NAME} VARCHAR(255) NOT NULL,
                ${COLUMN_VOTED} INTEGER NOT NULL CHECK (${COLUMN_VOTED} IN (0, 1))
            )
        """

        const val SQL_DROP = """
            DROP TABLE IF EXISTS ${TABLE_NAME}
        """

        const val SQL_WHERE_ID_EQUALS = """
            ${COLUMN_ID} = ?
        """
    }

    object Vote : BaseColumns {
        const val TABLE_NAME = "votes"
        const val COLUMN_ID = "vote_id"
        const val COLUMN_VALUE = "value"

        const val SQL_CREATE = """
            CREATE TABLE ${TABLE_NAME} (
                ${COLUMN_ID} TEXT PRIMARY KEY,
                ${COLUMN_VALUE} VARCHAR(20) NOT NULL
            )
        """

        const val SQL_DROP = """
            DROP TABLE IF EXISTS ${TABLE_NAME}
        """

        const val SQL_COUNT = """
            SELECT COUNT(${COLUMN_ID}) FROM ${TABLE_NAME}
        """

        const val SQL_COUNT_VALUE = """
            SELECT COUNT(${COLUMN_ID}) FROM ${TABLE_NAME} WHERE ${COLUMN_VALUE} = ?
        """

        const val SQL_WHERE_ID_EQUALS = """
            ${COLUMN_ID} = ?
        """
    }
}