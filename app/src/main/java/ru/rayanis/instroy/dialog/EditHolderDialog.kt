package ru.rayanis.instroy.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.rayanis.instroy.ui.theme.DarkText
import ru.rayanis.instroy.ui.theme.GrayLight

@Composable
fun EditHolderDialog(
    dialogController: EditHolderDialogController
) {
    if (dialogController.openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                dialogController.onEditHolderDialogEvent(EditHolderDialogEvent.OnCancel)
            },
            title = null,
            text = {
                Column(modifier = Modifier
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
                        value = dialogController.nameTextField.value,
                        onValueChange = { text ->
                            dialogController.onEditHolderDialogEvent(
                                EditHolderDialogEvent.OnNameChange(
                                    text
                                )
                            )
                        },
                        modifier = Modifier.padding(top = 5.dp),
                        label = {
                            Text(text = "Имя")
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
                        value = dialogController.phoneNumberTextField.value,
                        onValueChange = { text ->
                            dialogController.onEditHolderDialogEvent(
                                EditHolderDialogEvent.OnPhoneNumberChange(
                                    text
                                )
                            )
                        },
                        modifier = Modifier.padding(top = 5.dp),
                        label = {
                            Text(text = "Номер телефона")
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
                        value = dialogController.emailTextField.value,
                        onValueChange = { text ->
                            dialogController.onEditHolderDialogEvent(
                                EditHolderDialogEvent.OnEmailChange(
                                    text
                                )
                            )
                        },
                        modifier = Modifier.padding(top = 5.dp),
                        label = {
                            Text(text = "Email")
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
                        value = dialogController.telegramNicknameTextField.value,
                        onValueChange = { text ->
                            dialogController.onEditHolderDialogEvent(
                                EditHolderDialogEvent.OnTelegramNicknameChange(
                                    text
                                )
                            )
                        },
                        modifier = Modifier.padding(top = 5.dp),
                        label = {
                            Text(text = "Telegram")
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
                        value = dialogController.whatsappNumberTextField.value,
                        onValueChange = { text ->
                            dialogController.onEditHolderDialogEvent(
                                EditHolderDialogEvent.OnWhatsappNumberChange(
                                    text
                                )
                            )
                        },
                        modifier = Modifier.padding(top = 5.dp),
                        label = {
                            Text(text = "Whatsapp")
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
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    dialogController.onEditHolderDialogEvent(EditHolderDialogEvent.OnSave)
                }) {
                    Text(text = "Сохранить")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    dialogController.onEditHolderDialogEvent(EditHolderDialogEvent.OnCancel)
                }) {
                    Text(text = "Отмена")
                }
            }
        )
    }
}