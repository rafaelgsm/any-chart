package rafaelgsm.example.data_visualization.charts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.anychart.AnyChart
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.chart.common.listener.Event
import com.anychart.chart.common.listener.ListenersInterface
import kotlinx.android.synthetic.main.fragment_pie_chart.*
import rafaelgsm.example.data_visualization.R


class PieChartFragment : Fragment() {

    private val navController by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_pie_chart, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pie = AnyChart.pie()

        //region chart data and view setup
        val data = arrayListOf<DataEntry>()

        data.add(ValueDataEntry("John", 10000))
        data.add(ValueDataEntry("Jake", 12000))
        data.add(ValueDataEntry("Peter", 18000))

        pie.data(data)

        pie_chart.setChart(pie)
        //endregion chart data and view setup

        //The click listener is on the AnyChart object, and not on the View!
        //region char click listener
        pie.setOnClickListener(object :
            ListenersInterface.OnClickListener(arrayOf("x", "value")) {
            override fun onClick(event: Event) {
                val x = event.data["x"]
                val value = event.data["value"]

                Toast.makeText(context, "$x -> $value", Toast.LENGTH_SHORT).show()
            }
        })
        //endregion char click listener
    }

}