package ru.rayanis.instroy.instruments_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import ru.rayanis.instroy.ui.theme.DarkText
import ru.rayanis.instroy.ui.theme.GreenLight
import ru.rayanis.instroy.ui.theme.LightText
import ru.rayanis.instroy.ui.theme.Red
import ru.rayanis.instroy.ui.theme.White

@Preview(showBackground = true)
@Composable
fun UiInstrumentItem() {
    ConstraintLayout(modifier = Modifier.padding(
        start = 3.dp, top = 18.dp, end = 3.dp
    )) {
        val (card, deleteButton, editButton) = createRefs()
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
                    .padding(8.dp)
            ) {
                Text(
                    text = "Ильназ",
                    style = TextStyle(
                        color = DarkText,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                )
                Text(
                    text = "Доступное количество: 50",
                    style = TextStyle(
                        color = LightText,
                        fontSize = 12.sp
                    )
                )
            }
        }

        //Кнопка удаления
        IconButton(
            onClick = { },
            modifier = Modifier.constrainAs(deleteButton) {
                top.linkTo(card.top)
                bottom.linkTo(card.bottom)
                end.linkTo(card.end)
            }.padding(end = 10.dp).size(30.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.delete_icon),
                contentDescription = "Delete",
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Red)
                    .padding(5.dp),
                tint = White
            )
        }

        //Кнопка редактирования
        IconButton(
            onClick = { },
            modifier = Modifier.constrainAs(editButton) {
                top.linkTo(card.top)
                bottom.linkTo(card.bottom)
                end.linkTo(deleteButton.start)
            }.padding(end = 5.dp).size(30.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.edit_icon),
                contentDescription = "Edit",
                modifier = Modifier
                    .clip(CircleShape)
                    .background(GreenLight)
                    .padding(5.dp),
                tint = White
            )
        }
    }
}