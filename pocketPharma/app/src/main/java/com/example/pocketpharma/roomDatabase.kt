package com.example.pocketpharma

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(Record::class), version = 1, exportSchema = false)
public abstract class roomDatabase : RoomDatabase() {

    abstract fun recordDAO(): recordDAO

    private class recordDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var recordDAO = database.recordDAO()

                    // Delete all content here.
                    recordDAO.deleteAll()

                    // Add sample words.
                    var record = Record(1,"00051217-a7f5-45e9-8bd3-31415764bd4e","3549","TRICLOSANUM","TRICLOSAN","TRIKLOSAN")
                    recordDAO.insert(record)
                    record = Record(2,"0005936e-b770-4302-b84f-ca8336a38ee7","8809","CEFTRIAXONUM","CEFTRIAXONE","CEFTRIAXON")
                    recordDAO.insert(record)
                    record = Record(3,"0005936e-b770-4302-b84f-ca8336a38ee7","8809","CEFTRIAXONUM","CEFTRIAXONE","CEFTRIAXON")
                    recordDAO.insert(record)
                    record = Record(4,"0005936e-b770-4302-b84f-ca8336a38ee7","8809","CEFTRIAXONUM","CEFTRIAXONE","CEFTRIAXON")
                    recordDAO.insert(record)
                    record = Record(5,"0005936e-b770-4302-b84f-ca8336a38ee7","8809","CEFTRIAXONUM","CEFTRIAXONE","CEFTRIAXON")
                    recordDAO.insert(record)
                    record = Record(6,"0005936e-b770-4302-b84f-ca8336a38ee7","8809","CEFTRIAXONUM","CEFTRIAXONE","CEFTRIAXON")
                    recordDAO.insert(record)
                    record = Record(7,"0005936e-b770-4302-b84f-ca8336a38ee7","8809","CEFTRIAXONUM","CEFTRIAXONE","CEFTRIAXON")
                    recordDAO.insert(record)
                    record = Record(8,"0005936e-b770-4302-b84f-ca8336a38ee7","8809","CEFTRIAXONUM","CEFTRIAXONE","CEFTRIAXON")
                    recordDAO.insert(record)
                    record = Record(9,"0005936e-b770-4302-b84f-ca8336a38ee7","8809","CEFTRIAXONUM","CEFTRIAXONE","CEFTRIAXON")
                    recordDAO.insert(record)



                }
            }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: roomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): roomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    roomDatabase::class.java,
                    "sukl_database"
                )
                    .addCallback(recordDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}