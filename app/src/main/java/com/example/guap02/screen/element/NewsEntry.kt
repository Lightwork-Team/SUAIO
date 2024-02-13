package com.example.guap02.screen.element

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.guap02.R

@Composable
fun NewsEntry(
    title: String = "News title, lorem ipsum dolor sit amet and so on and so forth.",
    content: String = "News content, lorem ipsum dolor sit amet and so on and so forth. It will be " +
            "truncated if it's too long. Click to expand. News content, lorem ipsum dolor sit amet.",
    date: String = "19.01.2022",
    thumbnail: Int = R.drawable.ic_launcher_background
) {
    var isExpanded by remember { mutableStateOf(false) }
    Card(
        Modifier
            .padding(8.dp)
            .clickable {
                isExpanded = !isExpanded
            }) {
        Column(Modifier.padding(12.dp)) {
            Image(
                painter = painterResource(id = thumbnail),
                contentDescription = "Image thumbnail",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
                    .heightIn(min = 150.dp, max = 300.dp)
                    .clip(shape = MaterialTheme.shapes.medium),
                contentScale = ContentScale.FillBounds
            )
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = date,
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = content,
                maxLines = if (isExpanded) 255 else 2,
                style = MaterialTheme.typography.bodyMedium,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            if (!isExpanded) {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                    contentDescription = "Expand icon"
                )
            }
        }
    }
}

@Preview
@Composable
fun NewsEntryPreview() {
    NewsEntry(
    )
}
