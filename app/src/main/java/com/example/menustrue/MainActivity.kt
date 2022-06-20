package com.example.menustrue

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    companion object {
        private val ID_MENU_SETTINGS = Menu.FIRST
        private val ID_GROUP_BR = Menu.FIRST
        private val ID_ELEMENTO_CHECKBOX = Menu.FIRST
        private val ID_BOTON_RADIO_1 = Menu.FIRST + 1
        private val ID_BOTON_RADIO_2 = Menu.FIRST + 2
        private val ID_BOTON_RADIO_3 = Menu.FIRST + 3
        private val ID_SUBMENU = Menu.FIRST +4

        var count = 0
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menu?.add(Menu.NONE, ID_ELEMENTO_CHECKBOX, Menu.NONE, "Checkbox")
            ?.setCheckable(true)
        menu?.add(ID_GROUP_BR, ID_BOTON_RADIO_1, Menu.NONE, "opcion 1")
        menu?.add(ID_GROUP_BR, ID_BOTON_RADIO_2, Menu.NONE, "opcion 2")
        menu?.add(ID_GROUP_BR, ID_BOTON_RADIO_3, Menu.NONE, "opcion 3")
            ?.setChecked(true)
        menu?.setGroupCheckable(ID_GROUP_BR, true, true)
        val sub = menu?.addSubMenu(0,0, Menu.NONE, "titulo submenu")
        val elementoSubMenu = sub?.add (0, ID_SUBMENU, Menu.NONE, "elemento submenu")

        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
         super.onPrepareOptionsMenu(menu)
        val menuItem = menu?.findItem(ID_MENU_SETTINGS)
        menuItem?.intent = Intent(this, MainActivity2::class.java)
        count ++

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
         super.onOptionsItemSelected(item)
        when (item.itemId) {
            ID_MENU_SETTINGS -> {Toast.makeText(this, "opcion 1", Toast.LENGTH_LONG).show()
                return true}
            ID_BOTON_RADIO_1 -> {Toast.makeText(this, "opcion 1 radio boton", Toast.LENGTH_LONG).show()
                return true}
            ID_BOTON_RADIO_2 -> {Toast.makeText(this, "opcion 2 radio boton", Toast.LENGTH_LONG).show()
                return true}
            ID_BOTON_RADIO_3 -> { Toast.makeText(this, "opcion 2 radio boton", Toast.LENGTH_LONG).show()
                return  true }
            ID_SUBMENU  -> { Toast.makeText(this, "has pulsado submenu", Toast.LENGTH_LONG).show()
                return  true }


        }

        return false
    }



}