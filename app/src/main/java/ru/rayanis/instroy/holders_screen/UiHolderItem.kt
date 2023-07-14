package ru.rayanis.instroy.holders_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import ru.rayanis.instroy.R
import ru.rayanis.instroy.data.holder.Holder
import ru.rayanis.instroy.ui.theme.DarkText
import ru.rayanis.instroy.ui.theme.GreenLight
import ru.rayanis.instroy.ui.theme.Red
import ru.rayanis.instroy.ui.theme.White

@Composable
fun UiHolderItem(
    item: Holder,
    onEvent: (HoldersScreenEvent) -> Unit
) {
    ConstraintLayout(
        modifier = Modifier.padding(
            start = 3.dp, top = 18.dp, end = 3.dp
        )
    ) {
        val (card, editButton, deleteButton) = createRefs()
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(card) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .clickable {
//                    onEvent(HoldersScreenEvent.onHolderClick.)
                }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Text(
                    text = item.name,
                    style = TextStyle(
                        color = DarkText,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                )
            }
        }
        //Кнопка удаления
        IconButton(
            onClick = {
                onEvent(HoldersScreenEvent.OnShowDeleteDialog(item))
            },
            modifier = Modifier
                .constrainAs(deleteButton) {
                    top.linkTo(card.top)
                    bottom.linkTo(card.bottom)
                    end.linkTo(card.end)
                }
                .padding(end = 10.dp)
                .size(30.dp)
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
            onClick = {
                onEvent(HoldersScreenEvent.OnShowEditDialog(item))
            },
            modifier = Modifier
                .constrainAs(editButton) {
                    top.linkTo(card.top)
                    bottom.linkTo(card.bottom)
                    end.linkTo(deleteButton.start)
                }
                .padding(end = 5.dp)
                .size(30.dp)
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