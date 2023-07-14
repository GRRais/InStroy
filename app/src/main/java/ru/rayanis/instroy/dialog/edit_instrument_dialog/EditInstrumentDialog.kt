package ru.rayanis.instroy.dialog.edit_instrument_dialog

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.rayanis.instroy.R
import ru.rayanis.instroy.ui.theme.BlueLight
import ru.rayanis.instroy.ui.theme.DarkText
import ru.rayanis.instroy.ui.theme.GrayLight

@Composable
fun EditInstrumentDialog(
    dialogController: EditInstrumentDialogController
) {
    if (dialogController.openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                dialogController.onEditInstrumentDialogEvent(EditInstrumentDialogEvent.OnCancel)
            },
            title = null,
            text = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = dialogController.dialogTitle.value,
                        style = TextStyle(
                            color = DarkText,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        value = dialogController.instrumentNameText.value,
                        onValueChange = { text ->
                            dialogController.onEditInstrumentDialogEvent(
                                EditInstrumentDialogEvent.OnNameChange(
                                    text
                                )
                            )
                        },
                        modifier = Modifier.padding(top = 5.dp),
                        label = {
                            Text(text = "Наименование")
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = GrayLight,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(7.dp),
                        singleLine = true,
                        textStyle = TextStyle(
                            color = DarkText,
                            fontSize = 16.sp
                        )
                    )
                    TextField(
                        value = dialogController.additionalInfoText.value,
                        onValueChange = { text ->
                            dialogController.onEditInstrumentDialogEvent(
                                EditInstrumentDialogEvent.OnAdditionalInfoChange(
                                    text
                                )
                            )
                        },
                        modifier = Modifier.padding(top = 5.dp),
                        label = {
                            Text(text = "Дополнительная информация")
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = GrayLight,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(7.dp),
                        singleLine = true,
                        textStyle = TextStyle(
                            color = DarkText,
                            fontSize = 16.sp
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Доступно",
                                modifier = Modifier
                                    .padding(top = 5.dp)
                                    .weight(1.0f),
                                style = TextStyle(
                                    color = DarkText,
                                    fontSize = 16.sp
                                )
                            )
                            Text(
                                text = dialogController.freeAmountText.value.toString(),
                                modifier = Modifier.padding(top = 5.dp),
                                style = TextStyle(
                                    color = DarkText,
                                    fontSize = 16.sp
                                )
                            )
                            IconButton(onClick = {
                                /*TODO*/
                            }) {
                                Icon(
                                    painter = painterResource (id = R.drawable.edit_icon),
                                    contentDescription = "Change",
                                    modifier = Modifier.border(
                                        width = 2.dp,
                                        color = BlueLight,
                                        shape = RoundedCornerShape(5.dp)
                                    ).padding(1.dp),
                                    tint = BlueLight
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "На ремонте",
                                modifier = Modifier
                                    .padding(top = 5.dp)
                                    .weight(1.0f),
                                style = TextStyle(
                                    color = DarkText,
                                    fontSize = 16.sp
                                )
                            )
                            Text(
                                text = dialogController.brokenAmountText.value.toString(),
                                modifier = Modifier.padding(top = 5.dp),
                                style = TextStyle(
                                    color = DarkText,
                                    fontSize = 16.sp
                                )
                            )
                            IconButton(onClick = {
                                /*TODO*/
                            }) {
                                Icon(
                                    painter = painterResource (id = R.drawable.edit_icon),
                                    contentDescription = "Change",
                                    modifier = Modifier.border(
                                        width = 2.dp,
                                        color = BlueLight,
                                        shape = RoundedCornerShape(5.dp)
                                    ).padding(1.dp),
                                    tint = BlueLight
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Всего",
                                modifier = Modifier
                                    .padding(top = 5.dp)
                                    .weight(1.0f),
                                style = TextStyle(
                                    color = DarkText,
                                    fontSize = 16.sp
                                )
                            )
                            Text(
                                text = dialogController.maxAmountText.value.toString(),
                                modifier = Modifier.padding(top = 5.dp),
                                style = TextStyle(
                                    color = DarkText,
                                    fontSize = 16.sp
                                )
                            )
                            IconButton(onClick = {
                                /*TODO*/
                            }) {
                                Icon(
                                    painter = painterResource (id = R.drawable.edit_icon),
                                    contentDescription = "Change",
                                    modifier = Modifier.border(
                                        width = 2.dp,
                                        color = BlueLight,
                                        shape = RoundedCornerShape(5.dp)
                                    ).padding(1.dp),
                                    tint = BlueLight
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Списано",
                                modifier = Modifier
                                    .padding(top = 5.dp)
                                    .weight(1.0f),
                                style = TextStyle(
                                    color = DarkText,
                                    fontSize = 16.sp
                                )
                            )
                            Text(
                                text = dialogController.decommissionAmountText.value.toString(),
                                modifier = Modifier.padding(top = 5.dp),
                                style = TextStyle(
                                    color = DarkText,
                                    fontSize = 16.sp
                                )
                            )
                            IconButton(onClick = {
                                /*TODO*/
                            }) {
                                Icon(
                                    painter = painterResource (id = R.drawable.edit_icon),
                                    contentDescription = "Change",
                                    modifier = Modifier.border(
                                        width = 2.dp,
                                        color = BlueLight,
                                        shape = RoundedCornerShape(5.dp)
                                    ).padding(1.dp),
                                    tint = BlueLight
                                )
                            }
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    dialogController.onEditInstrumentDialogEvent(EditInstrumentDialogEvent.OnSave)
                }) {
                    Text(text = "Сохранить")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    dialogController.onEditInstrumentDialogEvent(EditInstrumentDialogEvent.OnCancel)
                }) {
                    Text(text = "Отмена")
                }
            }
        )
    }
}