package com.example.testaufgabe.presentation.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.example.testaufgabe.domain.model.SWItem
import com.example.testaufgabe.domain.model.SwapiResourceType
import com.example.testaufgabe.presentation.resource.SWListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SWListScreen(
    resourceType: SwapiResourceType,
    modifier: Modifier = Modifier,
    viewModel: SWListViewModel = hiltViewModel(),
    onMenuClick: () -> Unit
) {
    val pagingItems = viewModel
        .pagingFlowFor(resourceType)
        .collectAsLazyPagingItems()


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(resourceType.name.lowercase().replaceFirstChar { it.uppercase() }) },
                navigationIcon = {
                    IconButton(onClick = onMenuClick) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                }
            )
        },
        modifier = modifier,
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(count = pagingItems.itemCount, key = pagingItems.itemKey { it.id }) { index ->
                val item = pagingItems[index]
                if (item != null) {
                    SWItemRow(item = item, modifier = Modifier.padding(horizontal = 18.dp))
                }
            }
        }
    }
}

@Composable
fun SWItemRow(item: SWItem, modifier: Modifier = Modifier) {
    Card(modifier = modifier, shape = RoundedCornerShape(2.dp)) {
        Column {
            Text(
                text = item.title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            item.subtitle?.let {
                Text(
                    text = it,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SWItemRowPreview() {
    SWItemRow(
        item = SWItem(
            id = "1",
            title = "Luke Skywalker",
            subtitle = "Gender: male"
        ),
        modifier = Modifier
    )
}
