package com.example.assigment.ui.map

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

@Composable
fun GoogleMap() {
    AndroidView(
        modifier = Modifier.fillMaxSize(), // Occupy the max size in the Compose UI tree
        factory = { context ->
            MapView(context).apply {
                onCreate(null)
                getMapAsync { map ->
                    map.moveCamera(
                        CameraUpdateFactory.newLatLngZoom(
                            LatLng(22.3411605,114.17759),
                            15f
                        )
                    )
                    Building.data.forEach { building ->
                        map.addMarker(
                            MarkerOptions().position(
                                LatLng(building.latitude, building.longitude)
                            ).title(building.title)
                        )
                    }
                }
            }
        },
        update = { view -> view.onResume() }
    )
}
data class Building(val title:String, val latitude:Double, val longitude:Double) {
    companion object {
        val data = listOf(
            Building("AC Hall", 22.341280,114.179768),
            Building("Lam Woo International Conference Center", 22.337716, 114.182013),
            Building("Communication and Visual Arts Building", 22.334382, 114.182528)
        )
    }
}