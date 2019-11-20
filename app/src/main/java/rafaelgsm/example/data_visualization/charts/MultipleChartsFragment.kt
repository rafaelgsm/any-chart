package rafaelgsm.example.data_visualization.charts


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anychart.APIlib
import com.anychart.AnyChart
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import kotlinx.android.synthetic.main.fragment_multiple_charts.*
import rafaelgsm.example.data_visualization.R


/**
 * In order to build 2 charts at once, we have to set each of them as "active",
 * and build them one after the other.
 */
class MultipleChartsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_multiple_charts, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //1. Set active chart:
        APIlib.getInstance().setActiveAnyChartView(chart1)

        //2. Build first chart:
        buildLineChart()

        //3. Change active chart:
        APIlib.getInstance().setActiveAnyChartView(chart2)

        //4. Build second chart:
        buildPieChart()
    }

    private fun buildLineChart() {
        val line = AnyChart.line()

        val data = arrayListOf<DataEntry>()
        data.add(ValueDataEntry("2017.1", 6371664))
        data.add(ValueDataEntry("2017.2", 789622))
        data.add(ValueDataEntry("2018.1", 7216301))
        data.add(ValueDataEntry("2018.2", 1486621))
        data.add(ValueDataEntry("2019.1", 6000000))
        data.add(ValueDataEntry("2019.2", 5006210))

        line.data(data)

        line.title("Apples Imported (Kg)")

        chart1.setChart(line)
    }


    private fun buildPieChart() {
        val pie = AnyChart.pie()

        val data = arrayListOf<DataEntry>()
        data.add(ValueDataEntry("Apples", 8006210))
        data.add(ValueDataEntry("Pears", 789622))
        data.add(ValueDataEntry("Bananas", 7216301))
        data.add(ValueDataEntry("Grapes", 1486621))
        data.add(ValueDataEntry("Oranges", 1200000))

        pie.data(data)

        pie.title("Fruits imported in 2019 (in kg)")

        chart2.setChart(pie)
    }
}