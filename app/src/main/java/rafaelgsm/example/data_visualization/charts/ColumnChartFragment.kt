package rafaelgsm.example.data_visualization.charts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.anychart.AnyChart
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.chart.common.listener.Event
import com.anychart.chart.common.listener.ListenersInterface
import kotlinx.android.synthetic.main.fragment_column_chart.*
import rafaelgsm.example.data_visualization.R

class ColumnChartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_column_chart, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val column = AnyChart.column()

        //region chart data and view setup
        val data = arrayListOf<DataEntry>()

        data.add(ValueDataEntry("A", 123))
        data.add(ValueDataEntry("B", 321))
        data.add(ValueDataEntry("D", 111))

        column.data(data)

        column_chart.setChart(column)
        //endregion chart data and view setup

        //The click listener is on the AnyChart object, and not on the View!
        //region chart click listener
        column.setOnClickListener(object :
            ListenersInterface.OnClickListener(arrayOf("x", "value")) {
            override fun onClick(event: Event) {
                val x = event.data["x"]
                val value = event.data["value"]

                Toast.makeText(context, "$x -> $value", Toast.LENGTH_SHORT).show()
            }
        })
        //endregion chart click listener
    }

}