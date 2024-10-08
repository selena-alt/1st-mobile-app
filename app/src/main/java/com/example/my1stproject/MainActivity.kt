package com.example.my1stproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val findBusStop = findViewById<Button>(R.id.find_stop)

        findBusStop.setOnClickListener {
            //sets spinner element to busNumber val
            val busNumber = findViewById<Spinner>(R.id.bus_number)
            //sets spinner's selected element as a value
            val selectedBus = busNumber.selectedItem

            val busDirection = findViewById<Spinner>(R.id.bus_direction)
            val selectedDirection = busDirection.selectedItem

            //if both spinners have values selected then find stops for bus route and direction
            if (selectedBus != null && selectedDirection != null) {
                //function call
                val stopList = getStop(selectedBus.toString(), selectedDirection.toString())
                val stops = stopList.reduce { str, item -> str + '\n' + item }
                val stop = findViewById<TextView>(R.id.stops)
                stop.text = stops
                //linking value subtitle to textview element
                val subtitle = findViewById<TextView>(R.id.subtitle)
                subtitle.text = getSubtitle(selectedBus.toString(), selectedDirection.toString())
            }
        }
    }
    private fun getStop(bus: String, direction: String): List<String> {
        return when (bus to direction) {
            "160" to "To New York" -> listOf(
                "31899 Port Authority Drop Off",
                "32795 Boulevard at Market St",
                "11326 Paterson Ave at Hackensack St",
                "21682 30th St at Palisade Ave")

            "161" to "To New York" -> listOf(
                "31899 Port Authority Drop Off",
                "27270 Broadway Bus Terminal",
                "21682 30th St at Palisade Ave")

            "162" to "To New York" -> listOf(
                "31899 Port Authority Drop Off",
                "12174 Passaic St at Esplanade",
                "12187 Polifly Rd at Essex St")

            "163" to "To New York" -> listOf(
                "31899 Port Authority Drop Off",
                "30452 Hillcrest Rd at Morningside Rd",
                "13371 Van Neste Square Bus Terminal",
                "12231 Summit Ave & Essex St",
                "12278 Boulevard at Williams Ave",
                "14062 Valley Blvd at Marlboro Rd",
                "11326 Paterson Ave at Hackensack St",
                "21682 30th St at Palisade Ave")

            "164" to "To New York" -> listOf(
                "31899 Port Authority Drop Off",
                "12648 Central Ave + Greenwood Ave",
                "13371 Van Neste Square Bus Terminal",
                "12231 Summit Ave & Essex St",
                "14062 Valley Blvd at Marlboro Rd",
                "11326 Paterson Ave at Hackensack St")

            "160" to "From New York" -> listOf(
                "21266 Port Authority Bus Terminal",
                "21687 31st St at Bergenline Ave",
                "11329 Paterson Ave at Hackensack St",
                "32796 Boulevard At Veterans Pl")

            "161" to "From New York" -> listOf(
                "21266 Port Authority Bus Terminal",
                "21687 31st St at Bergenline Ave",
                "27270 Broadway Bus Terminal")

            "162" to "From New York" -> listOf(
                "21266 Port Authority Bus Terminal",
                "12108 Essex St at Polifly Rd",
                "12631 Passaic St + The Esplanade",
                "13458 Passaic St + Rochelle Ave",
                "13178 Paramus Rd at Arcadian Ave (Rt 4)")

            "163" to "From New York" -> listOf(
                "21266 Port Authority Bus Terminal",
                "21687 31st St at Bergenline Ave",
                "11329 Paterson Ave at Hackensack St",
                "14059 Valley Blvd at Marlboro Rd",
                "12275 Boulevard at Williams Ave",
                "12226 Summit Ave & Essex St",
                "13178 Paramus Rd at Arcadian Ave (Rt 4)",
                "13371 Van Neste Square Bus Terminal",
                "30452 Hillcrest Rd at Morningside Rd")

            "164" to "From New York" -> listOf(
                "21266 Port Authority Bus Terminal",
                "11329 Paterson Ave at Hackensack St",
                "14059 Valley Blvd at Marlboro Rd",
                "12275 Boulevard at Williams Ave",
                "12108 Essex St at Polifly Rd",
                "12226 Summit Ave & Essex St",
                "13371 Van Neste Square Bus Terminal",
                "12648 Central Ave + Greenwood Ave")
            else -> listOf("Will add more bus routes and stops...")
        }
    }
    private fun getSubtitle(bus: String, direction: String): String{
        return when (bus to direction) {
            "160" to "To New York" -> ("160 To New York:")
            "161" to "To New York" -> ("161 To New York:")
            "162" to "To New York" -> ("162 To New York:")
            "163" to "To New York" -> ("163 To New York:")
            "164" to "To New York" -> ("164 To New York:")
            "160" to "From New York" -> ("160 To Elmwood Park")
            "161" to "From New York" -> ("161 To Paterson:")
            "162" to "From New York" -> ("162 To Paramus:")
            "163" to "From New York" -> ("163 To Ridgewood:")
            "164" to "From New York" -> ("164 To Midland Park:")
            else -> ("Will add more bus stops...")
        }
    }
}
