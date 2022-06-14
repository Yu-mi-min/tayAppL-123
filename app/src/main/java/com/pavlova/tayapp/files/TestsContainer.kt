package com.pavlova.tayapp.files

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pavlova.tayapp.R
import com.pavlova.tayapp.model.ContentTestModel
import com.pavlova.tayapp.model.TestModel
import com.pavlova.tayapp.navigation.NavHostController
import com.pavlova.tayapp.screens.TestItem
import com.pavlova.tayapp.screens.testId
public var contentTest = 0
@Composable
public fun TestsContainer (navController: NavHostController){
 //   val navController = rememberNavController()

    if (testId == 1) {
        Column() {

            TestItem(TestModel(id = 1, mainText = R.raw.t1, rightAnswer = 5), navController)
            TestItem(TestModel(mainText = R.raw.t2, rightAnswer = 4), navController)
            TestItem(
                TestModel(
                    mainText = R.raw.t3,
                    rightAnswer = 1,
                    answer4 = null,
                    answer5 = null
                ), navController
            )
            TestItem(TestModel(mainText = R.raw.t4, rightAnswer = 1), navController)
            TestItem(
                TestModel(mainText = R.raw.t5, rightAnswer = 2, answer5 = null),
                navController
            )
            TestItem(TestModel(mainText = R.raw.t6, rightAnswer = 1), navController)
            TestItem(
                TestModel(mainText = R.raw.t7, rightAnswer = 1, answer5 = null),
                navController
            )
            TestItem(
                TestModel(mainText = R.raw.t8, rightAnswer = 4, answer5 = null),
                navController
            )
            TestItem(
                TestModel(mainText = R.raw.t9, rightAnswer = 3, answer5 = null),
                navController
            )
        contentTest = 9
        }
    }
    if (testId  == 2) {
        TestItem(TestModel(id = 1, mainText = R.raw.t10, rightAnswer = 1), navController)
        TestItem(
            TestModel(mainText = R.raw.t11, rightAnswer = 1, answer5 = null),
            navController
        )
        TestItem(TestModel(mainText = R.raw.t12, rightAnswer = 4), navController)
        TestItem(TestModel(mainText = R.raw.t13, rightAnswer = 2), navController)
        TestItem(TestModel(mainText = R.raw.t14, rightAnswer = 3), navController)
        TestItem(
            TestModel(
                mainText = R.raw.t15,
                rightAnswer = 1,
                answer4 = null,
                answer5 = null
            ), navController
        )
        TestItem(
            TestModel(
                mainText = R.raw.t16,
                rightAnswer = 1,
                answer4 = null,
                answer5 = null
            ), navController
        )
        TestItem(
            TestModel(
                mainText = R.raw.t17,
                rightAnswer = 1,
                answer4 = null,
                answer5 = null
            ), navController
        )
        contentTest = 8
    }
    if (testId  == 3) {
        TestItem(TestModel(mainText = R.raw.t18, rightAnswer = 3), navController)
        TestItem(TestModel(mainText = R.raw.t19, rightAnswer = 4), navController)
        TestItem(TestModel(mainText = R.raw.t20, rightAnswer = 2), navController)
        TestItem(TestModel(mainText = R.raw.t21, rightAnswer = 5), navController)
        TestItem(TestModel(mainText = R.raw.t22, rightAnswer = 3), navController)
        TestItem(
            TestModel(mainText = R.raw.t23, rightAnswer = 4, answer5 = null),
            navController
        )
        TestItem(TestModel(mainText = R.raw.t24, rightAnswer = 2), navController)
        TestItem(
            TestModel(
                mainText = R.raw.t25,
                rightAnswer = 3,
                answer4 = null,
                answer5 = null
            ), navController
        )
        TestItem(
            TestModel(mainText = R.raw.t26, rightAnswer = 4, answer5 = null),
            navController
        )
        TestItem(
            TestModel(
                mainText = R.raw.t27,
                rightAnswer = 1,
                answer4 = null,
                answer5 = null
            ), navController
        )
        TestItem(
            TestModel(mainText = R.raw.t28, rightAnswer = 1, answer5 = null),
            navController
        )
        TestItem(
            TestModel(
                mainText = R.raw.t29,
                rightAnswer = 3,
                answer4 = null,
                answer5 = null
            ), navController
        )
        contentTest = 12
    }
    if (testId  == 4) {
        TestItem(TestModel(mainText = R.raw.t30, rightAnswer = 5), navController)
        TestItem(
            TestModel(mainText = R.raw.t31, rightAnswer = 3, answer5 = null),
            navController
        )
        TestItem(
            TestModel(mainText = R.raw.t32, rightAnswer = 2, answer5 = null),
            navController
        )
        TestItem(TestModel(mainText = R.raw.t33, rightAnswer = 3), navController)
        TestItem(TestModel(mainText = R.raw.t34, rightAnswer = 4), navController)
        TestItem(TestModel(mainText = R.raw.t35, rightAnswer = 4), navController)
        TestItem(
            TestModel(mainText = R.raw.t36, rightAnswer = 3, answer5 = null),
            navController
        )
        TestItem(
            TestModel(mainText = R.raw.t37, rightAnswer = 3, answer5 = null),
            navController
        )
        TestItem(
            TestModel(mainText = R.raw.t38, rightAnswer = 4, answer5 = null),
            navController
        )
        TestItem(
            TestModel(mainText = R.raw.t39, rightAnswer = 2, answer5 = null),
            navController
        )
        TestItem(
            TestModel(mainText = R.raw.t40, rightAnswer = 2, answer5 = null),
            navController
        )
        TestItem(
            TestModel(mainText = R.raw.t41, rightAnswer = 3, answer5 = null),
            navController
        )
        contentTest = 12
    }
    if (testId  == 5) {
        TestItem(
            TestModel(mainText = R.raw.t80, rightAnswer = 2, answer5 = null),
            navController
        )
        TestItem(
            TestModel(mainText = R.raw.t81, rightAnswer = 3, answer5 = null),
            navController
        )
        TestItem(
            TestModel(mainText = R.raw.t82, rightAnswer = 2, answer5 = null),
            navController
        )
        TestItem(
            TestModel(mainText = R.raw.t83, rightAnswer = 4, answer5 = null),
            navController
        )
        TestItem(
            TestModel(mainText = R.raw.t84, rightAnswer = 1, answer5 = null),
            navController
        )
        TestItem(
            TestModel(mainText = R.raw.t85, rightAnswer = 3, answer5 = null),
            navController
        )
        TestItem(
            TestModel(
                mainText = R.raw.t86,
                rightAnswer = 1,
                answer3 = null,
                answer4 = null,
                answer5 = null
            ), navController
        )
        TestItem(TestModel(mainText = R.raw.t87, rightAnswer = 2), navController)
        TestItem(TestModel(mainText = R.raw.t88, rightAnswer = 3), navController)
        TestItem(TestModel(mainText = R.raw.t89, rightAnswer = 5), navController)
        contentTest = 10

    }

    if (testId  == 6) {
        TestItem(TestModel(mainText = R.raw.t90, rightAnswer = 1), navController)
        TestItem(TestModel(mainText = R.raw.t91, rightAnswer = 1), navController)
        TestItem(TestModel(mainText = R.raw.t92, rightAnswer = 5), navController)
        TestItem(TestModel(mainText = R.raw.t93, rightAnswer = 3), navController)
        TestItem(TestModel(mainText = R.raw.t94, rightAnswer = 5), navController)
        TestItem(TestModel(mainText = R.raw.t95, rightAnswer = 5), navController)
        TestItem(TestModel(mainText = R.raw.t96, rightAnswer = 4), navController)
        TestItem(TestModel(mainText = R.raw.t97, rightAnswer = 3), navController)
        TestItem(TestModel(mainText = R.raw.t98, rightAnswer = 4), navController)
        TestItem(
            TestModel(mainText = R.raw.t99, rightAnswer = 2, answer5 = null),
            navController
        )
        contentTest = 10
    }
    if (testId == 7) {
        TestItem(TestModel(mainText = R.raw.t42, rightAnswer = 3), navController)
        TestItem(TestModel(mainText = R.raw.t43, rightAnswer = 2), navController)
        TestItem(TestModel(mainText = R.raw.t44, rightAnswer = 1), navController)
        TestItem(TestModel(mainText = R.raw.t45, rightAnswer = 1), navController)
        TestItem(TestModel(mainText = R.raw.t46, rightAnswer = 4), navController)
        TestItem(TestModel(mainText = R.raw.t47, rightAnswer = 1), navController)
        TestItem(TestModel(mainText = R.raw.t48, rightAnswer = 4), navController)
        TestItem(
            TestModel(mainText = R.raw.t49, rightAnswer = 1, answer5 = null),
            navController
        )
        TestItem(
            TestModel(mainText = R.raw.t50, rightAnswer = 2, answer5 = null),
            navController
        )
        TestItem(TestModel(mainText = R.raw.t51, rightAnswer = 3), navController)
        TestItem(TestModel(mainText = R.raw.t52, rightAnswer = 4), navController)
        TestItem(TestModel(mainText = R.raw.t53, rightAnswer = 5), navController)
        contentTest = 12
    }
    if (testId  == 8) {
        TestItem(TestModel(mainText = R.raw.t54, rightAnswer = 1), navController)
        TestItem(TestModel(mainText = R.raw.t55, rightAnswer = 1), navController)
        TestItem(TestModel(mainText = R.raw.t56, rightAnswer = 5), navController)
        TestItem(TestModel(mainText = R.raw.t57, rightAnswer = 4), navController)
        TestItem(
            TestModel(mainText = R.raw.t58, rightAnswer = 3, answer5 = null),
            navController
        )
        TestItem(TestModel(mainText = R.raw.t59, rightAnswer = 5), navController)
        TestItem(TestModel(mainText = R.raw.t60, rightAnswer = 3), navController)
        TestItem(TestModel(mainText = R.raw.t61, rightAnswer = 5), navController)
        TestItem(TestModel(mainText = R.raw.t62, rightAnswer = 1), navController)
        TestItem(TestModel(mainText = R.raw.t63, rightAnswer = 3), navController)
        TestItem(TestModel(mainText = R.raw.t64, rightAnswer = 4), navController)
        TestItem(
            TestModel(mainText = R.raw.t65, rightAnswer = 3, answer5 = null),
            navController
        )
        contentTest = 12
    }
    if (testId  == 9) {
        TestItem(
            TestModel(mainText = R.raw.t66, rightAnswer = 3, answer5 = null),
            navController
        )
        TestItem(
            TestModel(mainText = R.raw.t67, rightAnswer = 1, answer5 = null),
            navController
        )
        TestItem(TestModel(mainText = R.raw.t68, rightAnswer = 5), navController)
        TestItem(TestModel(mainText = R.raw.t69, rightAnswer = 1), navController)
        TestItem(TestModel(mainText = R.raw.t70, rightAnswer = 2), navController)
        TestItem(
            TestModel(mainText = R.raw.t71, rightAnswer = 2, answer5 = null),
            navController
        )
        TestItem(
            TestModel(
                mainText = R.raw.t72,
                rightAnswer = 4,
                answer4 = null,
                answer5 = null
            ), navController
        )
        TestItem(TestModel(mainText = R.raw.t73, rightAnswer = 1), navController)
        TestItem(TestModel(mainText = R.raw.t74, rightAnswer = 2), navController)
        TestItem(TestModel(mainText = R.raw.t75, rightAnswer = 3), navController)
        TestItem(TestModel(mainText = R.raw.t76, rightAnswer = 4), navController)
        TestItem(TestModel(mainText = R.raw.t77, rightAnswer = 1), navController)
        TestItem(TestModel(mainText = R.raw.t78, rightAnswer = 5), navController)
        TestItem(TestModel(mainText = R.raw.t79, rightAnswer = 3), navController)
        contentTest = 14
    }
    if (testId == 10) {
        TestItem(
            TestModel(mainText = R.raw.t5, rightAnswer = 2, answer5 = null),
            navController
        )
        TestItem(TestModel(mainText = R.raw.t6, rightAnswer = 1), navController)
        TestItem(
            TestModel(mainText = R.raw.t7, rightAnswer = 1, answer5 = null),
            navController
        )
        TestItem(TestModel(mainText = R.raw.t12, rightAnswer = 4), navController)
        TestItem(TestModel(mainText = R.raw.t13, rightAnswer = 2), navController)
        TestItem(TestModel(mainText = R.raw.t20, rightAnswer = 2), navController)
        TestItem(TestModel(mainText = R.raw.t21, rightAnswer = 5), navController)
        TestItem(TestModel(mainText = R.raw.t33, rightAnswer = 3), navController)
        TestItem(TestModel(mainText = R.raw.t34, rightAnswer = 4), navController)
        TestItem(TestModel(mainText = R.raw.t87, rightAnswer = 2), navController)
        TestItem(TestModel(mainText = R.raw.t88, rightAnswer = 3), navController)
        TestItem(TestModel(mainText = R.raw.t95, rightAnswer = 5), navController)
        TestItem(TestModel(mainText = R.raw.t96, rightAnswer = 4), navController)
        TestItem(TestModel(mainText = R.raw.t97, rightAnswer = 3), navController)
        TestItem(TestModel(mainText = R.raw.t45, rightAnswer = 1), navController)
        TestItem(TestModel(mainText = R.raw.t46, rightAnswer = 4), navController)
        TestItem(TestModel(mainText = R.raw.t47, rightAnswer = 1), navController)
        TestItem(TestModel(mainText = R.raw.t61, rightAnswer = 5), navController)
        TestItem(TestModel(mainText = R.raw.t62, rightAnswer = 1), navController)
        TestItem(TestModel(mainText = R.raw.t63, rightAnswer = 3), navController)
        TestItem(TestModel(mainText = R.raw.t75, rightAnswer = 3), navController)
        TestItem(TestModel(mainText = R.raw.t76, rightAnswer = 4), navController)
        TestItem(TestModel(mainText = R.raw.t77, rightAnswer = 1), navController)

        contentTest = 23
    }
}
