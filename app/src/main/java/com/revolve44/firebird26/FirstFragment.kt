package com.revolve44.firebird26

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import java.util.*


class FirstFragment : Fragment() {
    private val chart: LineChart? = null
    private val seekBarX: SeekBar? = null
    private val tvX: TextView? = null
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
//
//        setupLineChart()
//        val chrt: LineDataSet
//
//        lineChart.data = lineDataWithCount(20, 400f)
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(
            R.layout.fragment1, container,
            false
        )
        val activity = activity as Context
        val lineChart = view.findViewById<LineChart>(R.id.lineChart1)
        var description: Description = lineChart.getDescription()
        val legend = lineChart.legend
        lineChartSetup(lineChart, description, legend)


        return view
    }

    private fun lineChartSetup(lineChart: LineChart, description: Description, legend: Legend){
        lineChart.isDragEnabled = true
        lineChart.setScaleEnabled(false)
        lineChart.getDescription().setEnabled(false)
        lineChart.legend.isEnabled = false // description of define line

        legend.position= Legend.LegendPosition.BELOW_CHART_CENTER

//        val upper_limit = LimitLine(65F, "danger")
//        upper_limit.lineWidth = 4F
//        upper_limit.enableDashedLine(10F,10F, 0F)
//        upper_limit.labelPosition = LimitLine.LimitLabelPosition.RIGHT_TOP
//        upper_limit.textSize = 15F
//
//        val lower_limit = LimitLine(35F, "too low")
//        lower_limit.lineWidth = 4F
//        lower_limit.enableDashedLine(10F,10F, 0F)
//        lower_limit.labelPosition = LimitLine.LimitLabelPosition.RIGHT_BOTTOM
//        lower_limit.textSize = 15F

        val leftAxis = lineChart.axisLeft
        leftAxis.removeAllLimitLines()
//        leftAxis.addLimitLine(upper_limit)
//        leftAxis.addLimitLine(lower_limit)
        //YAxis.YAxisLabelPosition.OUTSIDE_CHART
//        leftAxis.axisMaximum = 100F
//        leftAxis.axisMinimum = 25F

        leftAxis.enableGridDashedLine(30F, 30F, 0F)
        leftAxis.setDrawLimitLinesBehindData(true)


        val yValues = ArrayList<Entry>()
        yValues.add(Entry(0F, 19F))
        yValues.add(Entry(1F, 80F))
        yValues.add(Entry(2F, 59F))
        yValues.add(Entry(3F, 14F))
        yValues.add(Entry(4F, 56F))
        yValues.add(Entry(5F, 34F))

        var set1 = LineDataSet(yValues,"")
        Legend.LegendPosition.RIGHT_OF_CHART

        set1.fillAlpha = 110
        set1.setDrawHorizontalHighlightIndicator(false);
        //set1.disableDashedLine()
        set1.isHighlightEnabled = false
        val dataSet = ArrayList<ILineDataSet>()
        dataSet.add(set1)

        val data = LineData(dataSet)

        lineChart.data = data

        val values = arrayOf("jan", "feb", "mar", "nov", "oct", "apr")

        //   X
        val xAxis = lineChart.xAxis
        xAxis.setValueFormatter(MyXAxisValuesFormatter(values))
        xAxis.granularity = 1F
        xAxis.position = XAxis.XAxisPosition.BOTTOM

        set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        //set1.isDrawFilledEnabled

//        set1.setCircleColor(Color.WHITE);
//        set1.setHighLightColor(Color.rgb(244, 117, 117));
//        set1.setColor(Color.WHITE);
        set1.setDrawFilled(true);
        set1.fillColor = Color.RED;
        set1.fillAlpha = 200;

        set1.setCubicIntensity(0.2f);

    }

}