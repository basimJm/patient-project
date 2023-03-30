package come.basim.patient_android_project.presentation.features

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import come.basim.patient_android_project.presentation.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}