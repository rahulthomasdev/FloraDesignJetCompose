package com.example.floradesignjetcompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Center
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
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterVertically
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
                    .weight(0.08f)
                    .background(color = colorResource(id = R.color.floral_green)),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Brand name
                    Text(
                        text = "BRAND NAME",
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
                    .clip(shape = RoundedCornerShape(topStart = 45.dp, topEnd = 45.dp))
                    .background(color = colorResource(id = R.color.bg_white)),
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
                            .padding(16.dp)
                            .padding(top = 10.dp)
                            .fillMaxWidth()
                            .fillMaxHeight(0.25f),
                        shape = RoundedCornerShape(30.dp),
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
                                    modifier = Modifier.height(170.dp)
                                )
                            }
                        )
                    }
                    Spacer(modifier = Modifier.padding(vertical = 10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .background(color = colorResource(id = R.color.bg_white))
                            .clip(shape = RoundedCornerShape(16.dp)),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        RowButton(icon = R.drawable.flower)
                        RowButton(icon = R.drawable.bouquet)
                        RowButton(icon = R.drawable.giftbox)
                        RowButton(icon = R.drawable.arch)
                    }

                    Row(modifier = Modifier
                        .padding(top = 18.dp)
                        .fillMaxWidth(0.9f)
                        .wrapContentHeight()
                        .background(color = colorResource(id = R.color.bg_white)),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(text = "Popular Items",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.W700,
                            color = Color.Black
                        )
                        Text(text = "View All",
                            fontSize = 18.sp,
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
    selectedColor: Color = Color.Gray /* Color.Yellow */,
    unSelectedColor: Color = colorResource(id = R.color.gray_100) /* Color.Gray */,
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
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
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
            Surface(
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .align(BottomCenter),
                shape = CircleShape,
                color = Color.Black.copy(alpha = 0f)
            ) {
                DotsIndicator(
                    modifier = Modifier.padding(horizontal = 15.dp, vertical =5.dp),
                    totalDots = itemsCount,
                    selectedIndex = if (isDragged) pagerState.currentPage else pagerState.targetPage,
                    dotSize = 6.dp
                )
            }
        }
    }

}

@Composable
fun RowButton(icon: Int, color: Color = Color.White){
    Card(modifier = Modifier
        .padding(5.dp)
        .size(75.dp)
        .background(color, shape = RoundedCornerShape(20.dp)), elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)){
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
        contentPadding = PaddingValues(horizontal = 16.dp)
    ){
        items(products){product ->
            Card(modifier = Modifier
                .width(182.dp)
                .padding(end = 18.dp, top = 14.dp)
                .fillMaxHeight(0.7f), elevation = CardDefaults.cardElevation(4.dp),
                shape = MaterialTheme.shapes.medium, colors = CardDefaults.cardColors(Color.White)) {
                Column(modifier = Modifier
                    .fillMaxSize()) {
                    Image(painter = rememberAsyncImagePainter(model = product.imageURL),
                        contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.65f),
                        contentScale = ContentScale.FillBounds
                        )
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()) {
                        Column(modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .wrapContentHeight()) {
                            Text(text = product.Title, fontSize = 20.sp, fontWeight = FontWeight.W600, color = Color.Black, modifier = Modifier.padding(top = 8.dp, start = 8.dp, bottom = 4.dp))
                            Text(text = product.Price, fontSize = 18.sp, fontWeight = FontWeight.W500,color= colorResource(id = R.color.floral_green), modifier = Modifier.padding(top = 4.dp, start = 8.dp, bottom = 4.dp))
                        }
                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(bottom = 22.dp, top = 10.dp, end = 10.dp,)) {
                            Button(onClick = { /*TODO*/ },shape = RoundedCornerShape(14.dp), modifier = Modifier
                                .wrapContentWidth()
                                .fillMaxHeight()
                                .align(Alignment.End),
                                contentPadding = PaddingValues(0.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = colorResource(id = R.color.floral_green),
                                    contentColor = colorResource(id = R.color.white)
                                )) {
                                Icon(painter = painterResource(id = R.drawable.baseline_add_24) , modifier = Modifier.fillMaxSize(0.5f), contentDescription = null)
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
        .fillMaxHeight()
        .padding(16.dp)
        .padding(top = 3.dp)
        .background(color = colorResource(id = R.color.bg_white)),shape= RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp), colors = CardDefaults.cardColors(Color.White)
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
        Icon(painter = painterResource(id = R.drawable.baseline_location_on_24), contentDescription = null, modifier = Modifier.size(30.dp), tint = colorResource(
            id = R.color.gray_300
        )
        )
        Icon(painter = painterResource(id = R.drawable.baseline_shopping_bag_24), contentDescription = null, modifier = Modifier.size(30.dp), tint = colorResource(
            id = R.color.gray_300)
        )
        Icon(painter = painterResource(id = R.drawable.baseline_person_24), contentDescription = null, modifier = Modifier.size(30.dp), tint = colorResource(
            id = R.color.gray_300)
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