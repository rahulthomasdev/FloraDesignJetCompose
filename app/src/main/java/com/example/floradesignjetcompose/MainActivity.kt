package com.example.floradesignjetcompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.End
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.floradesignjetcompose.ui.theme.FloraDesignJetComposeTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    val images = listOf(
        "https://cdn.pixabay.com/photo/2023/05/30/12/01/peonies-8028434_1280.jpg",
        "https://cdn.pixabay.com/photo/2013/08/20/15/47/poppies-174276_1280.jpg",
        "https://cdn.pixabay.com/photo/2016/08/03/14/24/roses-1566792_1280.jpg",
        "https://cdn.pixabay.com/photo/2018/07/20/13/52/sunflower-3550693_1280.jpg"
    )
    val products= listOf(
        Product("https://cdn.pixabay.com/photo/2021/12/07/21/58/pattern-6854140_1280.png",
        "Art 1", "$10.00"),
        Product("https://cdn.pixabay.com/photo/2018/04/04/14/34/leaves-3289964_1280.png",
            "Art 2", "$5.00"),
        Product("https://cdn.pixabay.com/photo/2021/09/17/11/32/flowers-6632403_1280.png",
            "Art 3", "$15.00")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyScreen(images, products)
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MyScreen(images: List<String>, products: List<Product>) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.floral_green))
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
                    .weight(0.1f)
                    .background(color = colorResource(id = R.color.floral_green)),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Brand name
                    Text(
                        text = "Your Brand",
                        modifier = Modifier.weight(1f),
                        fontSize = 30.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )

                    // Search icon
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon",
                        modifier = Modifier.size(35.dp),
                        tint = Color.White
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.9f)
                    .clip(shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                    .background(color = Color.White),
                contentAlignment = Alignment.TopCenter
            ) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Content inside the box section
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .padding(top = 16.dp)
                            .fillMaxWidth(0.95f)
                            .fillMaxHeight(0.25f),
                        shape = RoundedCornerShape(16.dp),
                    ) {
                        AutoSlidingCarousel(
                            itemsCount = images.size,
                            itemContent = { index ->
                                AsyncImage(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data(images[index])
                                        .build(),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.height(200.dp)
                                )
                            }
                        )
                    }
                    Row(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(0.9f)
                            .fillMaxHeight(0.15f)
                            .background(Color.White)
                            .clip(shape = RoundedCornerShape(16.dp)),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        RowButton(icon = R.drawable.flower)
                        RowButton(icon = R.drawable.bouquet)
                        RowButton(icon = R.drawable.giftbox)
                        RowButton(icon = R.drawable.arch)
                    }

                    Row(modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(0.9f)
                        .wrapContentHeight()
                        .background(Color.White),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(text = "Popular Items",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Text(text = "View All",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = colorResource(id = R.color.floral_green)
                        )
                    }
                    ProductList(products = products)
                    BottomNav()
                }

            }
        }
    }
}

@Composable
fun IndicatorDot(
    modifier: Modifier = Modifier,
    size: Dp,
    color: Color
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(color)
    )
}

@Composable
fun DotsIndicator(
    modifier: Modifier = Modifier,
    totalDots: Int,
    selectedIndex: Int,
    selectedColor: Color = colorResource(id = R.color.floral_green) /* Color.Yellow */,
    unSelectedColor: Color = Color.Gray /* Color.Gray */,
    dotSize: Dp
) {
    LazyRow(
        modifier = modifier
            .wrapContentWidth()
            .wrapContentHeight()
    ) {
        items(totalDots) { index ->
            IndicatorDot(
                color = if (index == selectedIndex) selectedColor else unSelectedColor,
                size = dotSize
            )

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun AutoSlidingCarousel(
    modifier: Modifier = Modifier,
    autoSlideDuration: Long = 3000,
    pagerState: PagerState = remember { PagerState() },
    itemsCount: Int,
    itemContent: @Composable (index: Int) -> Unit,
) {
    val isDragged by pagerState.interactionSource.collectIsDraggedAsState()

    LaunchedEffect(pagerState.currentPage) {
        delay(autoSlideDuration)
        pagerState.animateScrollToPage((pagerState.currentPage + 1) % itemsCount)
    }

    Box(
        modifier = modifier.fillMaxWidth(),
    ) {
        HorizontalPager(count = itemsCount, state = pagerState) { page ->
            itemContent(page)
        }
        Surface(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .align(Alignment.BottomCenter),
            shape = CircleShape,
            color = Color.Black.copy(alpha = 0.5f)
        ) {
            DotsIndicator(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                totalDots = itemsCount,
                selectedIndex = if (isDragged) pagerState.currentPage else pagerState.targetPage,
                dotSize = 8.dp
            )
        }
    }
}

@Composable
fun RowButton(icon: Int, color: Color = Color.White){
    Card(modifier = Modifier
        .size(64.dp)
        .background(color, shape = RoundedCornerShape(16.dp)), elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)){
        val imagePainter = rememberAsyncImagePainter(icon)
        Image(
            painter = imagePainter,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun ProductList(products: List<Product>){
    LazyRow(modifier = Modifier.padding(vertical = 8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp)
    ){
        items(products){product ->
            Card(modifier = Modifier
                .padding(8.dp)
                .width(200.dp)
                .fillMaxHeight(0.7f), elevation = CardDefaults.cardElevation(4.dp),
                shape = MaterialTheme.shapes.medium, colors = CardDefaults.cardColors(Color.White)) {
                Column(modifier = Modifier
                    .fillMaxSize()) {
                    Image(painter = rememberAsyncImagePainter(model = product.imageURL),
                        contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.7f),
                        contentScale = ContentScale.FillBounds
                        )
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()) {
                        Column(modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .wrapContentHeight()) {
                            Text(text = product.Title, fontSize = 20.sp, color = Color.Black, modifier = Modifier.padding(top = 8.dp, start = 4.dp))
                            Text(text = product.Price, fontSize = 18.sp, color= Color.Gray, modifier = Modifier.padding(top = 8.dp, start = 4.dp))
                        }
                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()) {
                            Button(onClick = { /*TODO*/ },shape = RoundedCornerShape(8.dp), modifier = Modifier
                                .padding(8.dp)
                                .wrapContentWidth()
                                .fillMaxHeight()
                                .align(Alignment.End),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = colorResource(id = R.color.floral_green),
                                    contentColor = colorResource(id = R.color.white)
                                )) {
                                Text(text = "+",
                                    color = Color.White,
                                    fontSize = 20.sp)
                            }
                        }
                        
                    }

                }
            }

        }
    }
}

@Composable
fun BottomNav(){
    Card(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.9f)
        .padding(8.dp)
        .background(color = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp), colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(start = 24.dp, end = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
        Icon(painter = painterResource(id = R.drawable.baseline_settings_24), contentDescription = null , modifier = Modifier.size(30.dp), tint = colorResource(
            id = R.color.floral_green
        ))
        Icon(painter = painterResource(id = R.drawable.baseline_location_on_24), contentDescription = null, modifier = Modifier.size(30.dp), tint = Color.Gray
        )
        Icon(painter = painterResource(id = R.drawable.baseline_shopping_bag_24), contentDescription = null, modifier = Modifier.size(30.dp), tint = Color.Gray
        )
        Icon(painter = painterResource(id = R.drawable.baseline_person_24), contentDescription = null, modifier = Modifier.size(30.dp), tint = Color.Gray
        )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyScreenPreview() {

    MyScreen(images = listOf(
        "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__340.jpg",
        "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__340.jpg",
        "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__340.jpg",
        "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__340.jpg"
    ),products= listOf(
        Product("https://cdn.pixabay.com/photo/2021/12/07/21/58/pattern-6854140_1280.png",
            "Art 1", "$10.00"),
        Product("https://cdn.pixabay.com/photo/2018/04/04/14/34/leaves-3289964_1280.png",
            "Art 2", "$5.00"),
        Product("https://cdn.pixabay.com/photo/2021/09/17/11/32/flowers-6632403_1280.png",
            "Art 3", "$15.00")
    ))

}