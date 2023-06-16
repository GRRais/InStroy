package ru.rayanis.instroy.history_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import ru.rayanis.instroy.R
import ru.rayanis.instroy.data.Instrument
import ru.rayanis.instroy.main_screen.BottomNavItem
import ru.rayanis.instroy.ui.theme.DarkText
import ru.rayanis.instroy.ui.theme.GrayLight
import ru.rayanis.instroy.ui.theme.GreenLight
import ru.rayanis.instroy.ui.theme.LightText
import ru.rayanis.instroy.ui.theme.Red
import ru.rayanis.instroy.ui.theme.White

@Preview(showBackground = true)
@Composable
fun UiInstrumentItem(
    //item: Instrument
) {
    ConstraintLayout(
        modifier = Modifier.padding(
            start = 3.dp, top = 18.dp, end = 3.dp
        )
    ) {
        val (card, historyDateBlock, quantityText) = createRefs()
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(card) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(5.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Text(
                    text = "Шуруповерт",
                    style = TextStyle(
                        color = DarkText,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                )
            }
        }

        //Поле с количеством возвращенного инструмента
        Text(
            modifier = Modifier
                .constrainAs(quantityText) {
                    top.linkTo(card.top)
                    bottom.linkTo(card.bottom)
                    end.linkTo(historyDateBlock.start)
                }
                .padding(end = 8.dp),
            text = "1 шт",
            style = TextStyle(
                color = LightText,
                fontSize = 14.sp
            )
        )

        //Два поля с временем взятия и возврата инструмента
        Column(
            modifier = Modifier
                .constrainAs(historyDateBlock) {
                    top.linkTo(card.top)
                    bottom.linkTo(card.bottom)
                    end.linkTo(card.end)
                }
                .padding(end = 10.dp)
        ) {
            Text(
                text = "08:15 - 21/05/23",
                style = TextStyle(
                    color = DarkText,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
            )
            Text(
                text = "08:15 - 15/06/23",
                style = TextStyle(
                    color = DarkText,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
            )
        }
    }
}