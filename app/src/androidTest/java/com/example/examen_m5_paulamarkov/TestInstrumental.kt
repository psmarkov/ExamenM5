package com.example.examen_m5_paulamarkov

import androidx.lifecycle.Observer
import androidx.room.PrimaryKey
import androidx.room.Room
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.statement.UiThreadStatement
import androidx.test.platform.app.InstrumentationRegistry
import com.example.examen_m5_paulamarkov.Model.Local.BaseDatos.WalletDataBase
import com.example.examen_m5_paulamarkov.Model.Local.Dao.WalletDao
import com.example.examen_m5_paulamarkov.Model.Local.Data.SendMoneyLocal
import com.google.gson.annotations.SerializedName
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TestInstrumental {

    // Variables de prueba
    private lateinit var walletDao : WalletDao
    private lateinit var db : WalletDataBase

    @Before
    fun setup() {
        // Inicialización de la base de datos y el DAO
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(context, WalletDataBase::class.java).build()
        walletDao = db.getWalletDao()
    }

    @After
    fun teardown() {
        // Cierre de la base de datos
        db.close()
    }

    @Test
    fun testCrudOperations() = runBlocking {
        // Creación de datos de prueba

        val coursesEntity = listOf(
           SendMoneyLocal(1, "monto1", "concept1", "date1", "type1",1,1,2,"updatedAt1","createdAt1"),
            SendMoneyLocal(2, "monto2", "concept2", "date2", "type2",2,2,1,"updatedAt2","createdAt2")
        )

        // Insertar los datos de prueba en la base de datos
        walletDao.insertAllTransac(coursesEntity)

        // Observar LiveData en el hilo principal
        UiThreadStatement.runOnUiThread {
            // Obtener LiveData de todos los cursos
            val allCoursesLiveData = walletDao.getAllWallet()

            // Crear el observador para los cursos
            val coursesObserver = Observer<List<SendMoneyLocal>> { miconciertoList ->

                ViewMatchers.assertThat(miconciertoList, CoreMatchers.not(emptyList()))
                // Realizar las aserciones dentro del observador
                TestCase.assertEquals(2, miconciertoList.size)
            }

            // Observar los cursos
            allCoursesLiveData.observeForever(coursesObserver)

            // Quitar el observador después de realizar las aserciones
            allCoursesLiveData.removeObserver(coursesObserver)
        }
    }



}