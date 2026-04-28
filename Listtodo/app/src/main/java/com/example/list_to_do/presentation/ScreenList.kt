package com.example.list_to_do.presentation

import android.R.attr.horizontalDivider
import android.graphics.Paint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ScreenList() {
    val viewModel = ListViewModel()
    ScreenContent(modifier = Modifier, viewModel = viewModel)
}

//@Composable
//fun ScreenContent(modifier: Modifier) {
//    //val list = mutableListOf<String>("merli", "chata","pulga") // mmutable porque voy a poner y quitar cosas
//    //list.removeAt(index= 0) // tener cuidado con remove y remove at uno es para string y otro para enteros
//    val list = remember { mutableStateListOf("merli","chata","pulga") } // Crea una lista mutable observable
//    // no puedes utilizar la asignacion "by", mutableStateListof no devuelve un State<T>
//    // puedes hacerlo e.g var list by remember{mutableStateOf(listOf("merli","pulga")}
//    // ahora para agregar valores list = list + "hola", si solo quieres ver su estado entonces pondrias val.
//    // crea una nueva lista, Compose observa el cambio.
//    // Importante mutableStateOf no sabe que hay en la lista solo la referencia.
//    // Si crearas una mutable dentro y quisieras ocupar los comando como list.add() no podrias porque mutableSTateOf no sabe que hay dentro.
//
//
//
//    MutableStateOf Guarda un valor. Notifica a Compose cuando ese valor cambia
//Compose detecta que ese estado cambió. Se vuelve a ejecutar (recomponer) la función composable que usa ese estado.
//La UI se actualiza automáticamente.
//    Recomposición (Recomposition)
// Compose:  Vuelve a ejecutar solo las funciones que leen ese estado.
// No reconstruye toda la pantalla.
//Solo actualiza la parte necesaria.
//
//
//
//    LazyColumn(
//        modifier
//            .fillMaxSize()
//            .safeContentPadding(),
//        verticalArrangement = Arrangement.Top,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        itemsIndexed(list) { index, item ->
//            Row(horizontalArrangement = Arrangement.spacedBy(14.dp)) {
//                Box(modifier.align(Alignment.CenterVertically)) {
//                    Text("${index + 1} $item")
//                }
//                IconButton(onClick = {list.removeAt(index)}) {
//                    Icon(
//                        imageVector = Icons.Default.Close,
//                        contentDescription = "Remove"
//                    )
//                }
//            }
//
//        }
//    }
//}


//@Composable
//fun ScreenContent(modifier: Modifier, viewModel: ListViewModel) {
//
//    val list by viewModel.list.collectAsStateWithLifecycle()
//    val text by viewModel.text.collectAsStateWithLifecycle()
//    Column(
//        modifier
//            .fillMaxSize()
//            .safeContentPadding()
//    ) {
//        LazyColumn(
//            modifier
//                .weight(1f)
//                .fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            itemsIndexed(list) { index, item ->
//                Row(
//                    modifier = Modifier
//                        .padding(4.dp)
//                        .background(MaterialTheme.colorScheme.tertiaryContainer)
//                        .fillMaxWidth()
//                        .padding(horizontal = 6.dp),
//                    horizontalArrangement = Arrangement.SpaceBetween,
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Text(text = " ${index + 1}  $item") // el align que podria pone aqui solo funciona dentro de un text. No con column o row, text no tiene dimensiones como box por eso no se puede.
//                    IconButton(onClick = { viewModel.Remove(index) }) {
//                        Icon(
//                            imageVector = Icons.Default.Close,
//                            contentDescription = "Remove"
//                        )
//                    }
//                }
//
//            }
//
//
//        }
//        Row(
//            modifier = modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            TextField(
//                value = text,
//                onValueChange = {newText -> viewModel.OnClickChanged(newText)},
//                enabled = true,
//                placeholder = { Text("Nueva tarea") })
//            Box() {
//                FloatingActionButton(
//                    onClick = { viewModel.Add() },
//                    modifier = Modifier.align(Alignment.BottomEnd) // Box trabaja en dos dimensiones por eso hay que especificar si es bottom.End, center.End, top.End
//                ) {
//                    Icon(Icons.Default.Add, contentDescription = "Agregar")
//                }
////        Button(modifier = modifier.align(Alignment.CenterEnd),onClick = {}) {
////            Text("+")
////        }
//
//            }
//        }
//
//
//    }
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenContent(modifier: Modifier, viewModel: ListViewModel) {
    val list by viewModel.list.collectAsStateWithLifecycle()
    val showDialog by viewModel.showDialog.collectAsStateWithLifecycle()
    val text by viewModel.text.collectAsStateWithLifecycle()
    Scaffold(
        modifier = Modifier.safeContentPadding(),
        topBar = {
            TopAppBar(
                title = { Text("Lista de tareas", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.tertiary,
                    titleContentColor = MaterialTheme.colorScheme.onTertiary
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {viewModel.openDialog()},
                containerColor = MaterialTheme.colorScheme.tertiary,
                contentColor = MaterialTheme.colorScheme.onTertiary //FloatingActionButtonDefaults.containerColor
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Agregar"
                )
            }
        }) { innerPadding ->
        Column(Modifier.padding(innerPadding), verticalArrangement = Arrangement.spacedBy(50.dp)) {
            if (showDialog){
                AlertDialog( onDismissRequest = { viewModel.closeDialog() },
                title = { Text("Agregar nueva tarea") },
                text = {
                    TextField(
                        value = text,
                        onValueChange = { viewModel.OnClickChanged(it) },
                        placeholder = { Text("Escribe la tarea") }
                    )
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            viewModel.Add()
                            viewModel.closeDialog()
                        }
                    ) { Text("Agregar") }
                },
                dismissButton = {
                    TextButton(onClick = { viewModel.closeDialog() }) {
                        Text("Cancelar")
                    }
                }
                )
            }
            LazyColumn(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            bottomStart = 24.dp,
                            bottomEnd = 24.dp
                        )
                    )
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.tertiaryContainer),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                itemsIndexed(list) { index, item -> // la funcion se llama itemsIndexed lo que sucede dentro es que saca los indices y el nombre
                    // de cada item y te los devuelve mediante index, item. Le entregas la lista y la accion que hara con index e item que es lo de abajo.
                    Row(
                        modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Row es el padre toda la linea horizontal y lo llenas con los siguientes contenedores
                        // Si quisieras otra fila simplemente agregas otro row abajo de este (no dentro) y dentro de una columna
                        Text("${index + 1}  ${item.name}")
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                onCheckedChange = { viewModel.onCheckBox(index) },
                                checked = item.checked,
                                colors = CheckboxDefaults.colors(
                                    checkmarkColor = MaterialTheme.colorScheme.onTertiary,
                                    checkedColor = MaterialTheme.colorScheme.tertiary
                                ),
                                modifier = Modifier.semantics {
                                    testTag = "$index check"

                                }
                            )
                            IconButton(onClick = { viewModel.Remove(index) }) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Remove"
                                )
                            }
                        }
                    }
                    HorizontalDivider(
                        thickness = 2.dp,
                        color = MaterialTheme.colorScheme.onTertiary.copy(0.5f)
                    )
                }


            }

        }


    }

}