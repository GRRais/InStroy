package ru.rayanis.instroy.add_instruments_screen

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
        val (card, removeButton, addButton, counter, quantityText) = createRefs()
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(card) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
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

        //Поле доступного количества
        Text(
            modifier = Modifier
                .constrainAs(quantityText) {
                    top.linkTo(card.top)
                    bottom.linkTo(card.bottom)
                    end.linkTo(removeButton.start)
                }
                .padding(end = 5.dp),
            text = "50 шт",
            style = TextStyle(
                color = LightText,
                fontSize = 14.sp
            )
        )

        //Кнопка добавления
        IconButton(
            onClick = { },
            modifier = Modifier
                .constrainAs(addButton) {
                    top.linkTo(card.top)
                    bottom.linkTo(card.bottom)
                    end.linkTo(card.end)
                }
                .padding(end = 8.dp)
                .size(25.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.add_icon),
                contentDescription = "Add",
                modifier = Modifier
                    .clip(CircleShape)
                    .background(GreenLight)
                    .padding(5.dp),
                tint = White
            )
        }

        //Поле ввода количества
        Card(
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .constrainAs(counter) {
                    top.linkTo(card.top)
                    bottom.linkTo(card.bottom)
                    end.linkTo(addButton.start)
                }
                .padding(end = 5.dp)
                .border(3.dp, Color.DarkGray, shape = RoundedCornerShape(5.dp))
        ) {
            Text(
                text = "0",
                style = TextStyle(
                    color = LightText,
                    fontSize = 20.sp
                ),
                modifier = Modifier
                    .background(White)
                    .padding(
                        top = 3.dp,
                        bottom = 3.dp,
                        start = 10.dp,
                        end = 10.dp
                    ),
                color = DarkText
            )
        }

        //Кнопка удаления
        IconButton(
            onClick = { },
            modifier = Modifier
                .constrainAs(removeButton) {
                    top.linkTo(card.top)
                    bottom.linkTo(card.bottom)
                    end.linkTo(counter.start)
                }
                .padding(end = 5.dp)
                .size(25.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.remove_icon),
                contentDescription = "Remove",
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Red)
                    .padding(5.dp),
                tint = White
            )
        }
    }
}