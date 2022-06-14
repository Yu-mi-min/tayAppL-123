package com.pavlova.tayapp.forPdf

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel


import com.pavlova.tayapp.MainViewModel
import com.pavlova.tayapp.model.TextModel
import com.pdftron.pdf.utils.Utils


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun addPdfInRoom () {

    val paragraphList1 = mutableListOf<TextModel>(
        TextModel(subtitle = "§1. Структура системы управления", mainText = "raw/p1.pdf"),
        TextModel(subtitle = "§2. Принцип работы регулятора", mainText = "raw/p2.pdf"),
        TextModel(subtitle = "§3. Классификация систем управления", mainText = "raw/p3.pdf"),

    )
    val paragraphList2 = mutableListOf<TextModel>(
        TextModel(subtitle = "§4. Основные понятия. Связь входа и выхода", mainText = "raw/p4.pdf"),
        TextModel(subtitle = "§5. Способы построения моделей", mainText = "raw/p5.pdf"),
        TextModel(subtitle = "§6. Линейность и нелинейность", mainText = "raw/p6.pdf"),
        TextModel(subtitle = "§7. Линеаризация уравнений", mainText = "raw/p7.pdf"),
    )
    val paragraphList3 = mutableListOf<TextModel>(
        TextModel(subtitle = "§8. Виды воздействий на САУ", mainText = "raw/p8.pdf"),
        TextModel(subtitle = "§9. Стандартная форма записи дифференциальных уравнений", mainText = "raw/p9.pdf"),
        TextModel(subtitle = "§10. Операционный метод описания линейных САУ. Основные свойства преобразования Лапласа", mainText = "raw/p10.pdf"),
        TextModel(subtitle = "§11. Передаточная функция. Свойства и особенности передаточной функции", mainText = "raw/p11.pdf"),
    )
    val paragraphList4 = mutableListOf<TextModel>(
        TextModel(subtitle = "§12. Обозначения в структурных схемах. Передаточные функции типовых соединений звеньев", mainText = "raw/p12.pdf"),
        TextModel(subtitle = "§13. Дополнительные правила преобразования структурных схем", mainText = "raw/p13.pdf"),
        TextModel(subtitle = "§14. Определение передаточных функций замкнутой САУ по ее структурной схеме", mainText = "raw/p14.pdf"),
    )
    val paragraphList5 = mutableListOf<TextModel>(
        TextModel(subtitle = "§15. Частотные характеристики", mainText = "raw/p15.pdf"),
        TextModel(subtitle = "§16. Логарифмические частотные характеристики", mainText = "tp16.pdf"),
        TextModel(subtitle = "§17. Соотношения взаимосвязи характеристик САУ между собой и передаточной функцией", mainText = "raw/p17.pdf"),
    )
}
/*@Composable
fun parseParagraph(paragraphs: List<TextModel>, viewModel: MainViewModel){

          val docPDF =  getResourceFromString(context, paragraph.mainText)

}*/
//получаем вфйл из папки raw
fun getResourceFromString(context: Context, resString: String?): Int {
    return Utils.getResourceRaw(
        context,
        resString!!.substringBeforeLast('.', "")
    )
}