package com.example.baguiorecow

import RecommendationAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecommendationActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecommendationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommendation) // Make sure this layout includes recyclerView

        val backButton = findViewById<ImageButton>(R.id.backButton)
        backButton.setOnClickListener {
            onBackPressed()
        }

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerViewRecommendations)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Set category title
        val category = intent.getStringExtra("CATEGORY") ?: "Coffee Shops"
        findViewById<TextView>(R.id.recommendationTitle).text = category

        // Load recommendations and set adapter
        val recommendations = loadRecommendations(category)
        adapter = RecommendationAdapter(recommendations) { recommendation ->
            val intent = Intent(this, RecommendationDetailActivity::class.java).apply {
                putExtra("RECOMMENDATION_NAME", recommendation.name)
                putIntegerArrayListExtra("RECOMMENDATION_IMAGES", ArrayList(recommendation.images))
                putExtra("RECOMMENDATION_DESCRIPTION", recommendation.description)
            }
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }

    private fun loadRecommendations(category: String): List<Recommendation> {
        return when (category) {
            "Coffee Shops" -> listOf(
                Recommendation(
                    "Starbucks",
                    listOf(R.drawable.sb1, R.drawable.sb2, R.drawable.sb3),
                    "Starbucks in Baguio City offers a unique blend of local charm and global coffeehouse experience. Nestled in the heart of the city, this cozy spot is known for its specialty coffees, featuring locally sourced beans and seasonal drinks inspired by the cool, crisp mountain climate. With its warm ambiance and stunning views of the surrounding landscape, it's the perfect place to relax, catch up with friends, or enjoy a moment of solitude. Whether you’re craving a classic espresso, a refreshing Frappuccino, or one of their signature pastries, Starbucks Baguio delivers an inviting atmosphere that feels like home."
                ),
                Recommendation(
                    "Dunkin' Donuts",
                    listOf(R.drawable.dd1, R.drawable.dd2, R.drawable.dd3),
                    "Famous for its coffee and baked goods."
                ),
                Recommendation(
                    "Beans Talk",
                    listOf(R.drawable.b1, R.drawable.b2, R.drawable.b3),
                    "Beans Talk Bistro provides quality food, pastries, and beverages at reasonable prices."
                ),
                Recommendation(
                    "Cafe Stella",
                    listOf(R.drawable.c1, R.drawable.c2, R.drawable.c3),
                    "Indulge in the Finest French Cuisine and Wine at Our Bistro. Experience the authentic taste of France with our delectable escargot and exquisite wine pairings"
                ),
                Recommendation(
                    "Seattle's Best Coffee",
                    listOf(R.drawable.s1, R.drawable.s2, R.drawable.s3),
                    "n/a"
                )
            )

            "Gyms" -> listOf(
                Recommendation(
                    "Hane's Sports and Gym",
                    listOf(R.drawable.h1, R.drawable.h2, R.drawable.h3),
                    "n/a"
                ),
                Recommendation(
                    "Royale Fitness Hub",
                    listOf(R.drawable.r1, R.drawable.r2, R.drawable.r3),
                    "n/a"
                ),
                Recommendation(
                    "Fitness Zone",
                    listOf(R.drawable.f1, R.drawable.f2, R.drawable.f3),
                    "n/a"
                ),
                Recommendation(
                    "Altitude Gym",
                    listOf(R.drawable.a1, R.drawable.a2, R.drawable.a3),
                    "n/a"
                ),
                Recommendation(
                    "SHAPE-UP",
                    listOf(R.drawable.z1, R.drawable.z2, R.drawable.z3),
                    "n/a"
                )
            )

            "Restaurants" -> listOf(
                Recommendation(
                    "The Bistro",
                    listOf(R.drawable.v1, R.drawable.q1, R.drawable.v3),
                    "A new take on your favorite Filipino flavors created with the best of Organic Cordilleran ingredients"
                ),
                Recommendation(
                    "Choco-late De Batirol",
                    listOf(R.drawable.q1, R.drawable.q2, R.drawable.q3),
                    "The “only” home of the best Choco-Late’ de Batirol in the Philippines!"
                ),
                Recommendation(
                    "Farmer's Daughter",
                    listOf(R.drawable.w1, R.drawable.w2, R.drawable.w3),
                    "A Restaurant that serves you the taste of Cordillera."
                ),
                Recommendation(
                    "Lemon and Olives",
                    listOf(R.drawable.e1, R.drawable.e2, R.drawable.e3),
                    "Greek Taverna is Baguio City's first-ever authentic Greek restaurant."
                ),
                Recommendation(
                    "Hill Station",
                    listOf(R.drawable.t1, R.drawable.t2, R.drawable.t3),
                    " offer dishes that blend the flavors of Asia's hill stations with the tastes of Old World Europe and New World America."
                )
            )

            "Parks" -> listOf(
                Recommendation(
                    "Burnham Park",
                    listOf(R.drawable.y1, R.drawable.y2, R.drawable.y3),
                    "The park was envisioned by American architect Daniel Hudson Burnham as part of a larger plan for the city of Baguio in 1905."
                ),
                Recommendation(
                    "Botanical Garden",
                    listOf(R.drawable.i1, R.drawable.i2, R.drawable.i3),
                    "A beautiful garden featuring diverse plants."
                ),
                Recommendation(
                    "Wright Park",
                    listOf(R.drawable.o1, R.drawable.o2, R.drawable.o3),
                    "The park is named after Governor Luke E. Wright who ordered architect Daniel Burnham to develop the place for American soldiers and civilians alike to have an area for recreation and leisure."
                ),
                Recommendation(
                    "Mirador Heritage And Eco Park",
                    listOf(R.drawable.l1, R.drawable.l2, R.drawable.l3),
                    "Situated in the Dominican Hill, it was once the site of the Dominican Retreat House, which played various roles throughout its existence - from being a vacation house for the Dominicans, a refugee center during World War II, to becoming the famed Diplomat Hotel in the 1970s."
                ),
                Recommendation(
                    "Mines View Park",
                    listOf(R.drawable.p1, R.drawable.p2, R.drawable.p3),
                    "Mines View Park is an overlook park on the northeastern outskirts of Baguio in the Philippines. Located on a land promontory 4 kilometres from downtown Baguio"
                )
            )


            "Bars" -> listOf(
                Recommendation(
                    "Lockdown Bar",
                    listOf(R.drawable.a11, R.drawable.a12, R.drawable.a13),
                    "Located inside Cholos Gastropark, Lockdown Bar is the chillest spot to hangout in the City of Pines"
                ),
                Recommendation(
                    "Vérvé Music Lounge",
                    listOf(R.drawable.n1, R.drawable.n2, R.drawable.n3),
                    "Come & Sing the night away here in Verve Music lounge! Sing freely,Chill out with your friends & Exp."
                ),
                Recommendation(
                    "Basmnt",
                    listOf(R.drawable.j1, R.drawable.j2, R.drawable.j3),
                    "The Only Basement Bar In Town That Overlooks The View Of The City."
                ),
                Recommendation(
                    "The Ampersand",
                    listOf(R.drawable.m1, R.drawable.m2, R.drawable.m3),
                    "Step into Baguio’s nightlife scene at The Ampersand. Where the music never stops, and the good times are guaranteed. Get ready to dance the night away at the iconic nightspot in town."
                ),
                Recommendation(
                    "Smoke and Barrel",
                    listOf(R.drawable.u1, R.drawable.u2, R.drawable.u3),
                    "Tired of the long queues and over crowded spots? Smoke and Barrel is your breath of fresh air."
                )
            )
            "Tourist Spots" -> listOf(
                Recommendation(
                    "Yellow Trail",
                    listOf(R.drawable.x1, R.drawable.x2, R.drawable.x3),
                    "Known for its towering pine trees, picnic spots, amusement activities and distinct Americana feel, this former US military recreational facility also has natural hidden gems that are not known to many."
                ),
                Recommendation(
                    "La Trinidad Strawberry Farm",
                    listOf(R.drawable.d1, R.drawable.d2, R.drawable.d3),
                    "you want to experience picking strawberries like you are not in the tropics? spare around 800 pesos to get the feeling."
                ),
                Recommendation(
                    "Baguio Night Market",
                    listOf(R.drawable.g1, R.drawable.g2, R.drawable.g3),
                    "Baguio Night Market, commonly known as Harrison Road Night Market, is a must-visit."
                ),
                Recommendation(
                    "Baguio Craft Brewery and Craft 1945",
                    listOf(R.drawable.k1, R.drawable.k2, R.drawable.k3),
                    "Craft 1945 is an old house turned into a new Baguio heritage."
                )
            )
            "Events" -> listOf(
                Recommendation(
                    "Panagbenga",
                    listOf(R.drawable.qq1, R.drawable.qq2, R.drawable.qq3),
                    "he annual Baguio Flower Festival, which takes place in February. The name \"Panagbenga\" comes from the Kankanaey term for \"season of blooming\". The festival includes a parade, a floral float parade, a street dance parade, and more."
                ),
                Recommendation(
                    "Baguio Cosplay Festival",
                    listOf(R.drawable.ww1, R.drawable.ww2, R.drawable.ww3),
                    "A celebration of creativity held in Session Road. The festival includes activities for artists, cosplayers, and creative people"
                ),
                Recommendation(
                    "Mangan Taku Food Festival",
                    listOf(R.drawable.ee1, R.drawable.ee2, R.drawable.ee3),
                    "An annual festival that takes place in April and celebrates Baguio's culinary traditions. The festival includes culinary competitions, food crawls, and concerts.."
                )
            )




            else -> emptyList()
        }
    }
}
