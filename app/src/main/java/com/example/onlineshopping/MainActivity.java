package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.example.onlineshopping.Adapter.HomeAdapter;
import com.example.onlineshopping.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<Product> homeproductList = new ArrayList<>();
    ArrayList<Product> profileProductList = new ArrayList<>();

    private RecyclerView recyclerView;
    private HomeAdapter mAdapter;
    private SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new HomeAdapter(homeproductList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        readyHomeProductData();
    }

    public void readyProfileData() {

        Product Blazer = new Product("Blazer", "https://static-01.daraz.com.bd/original/3c62ec36f98e670c3b6ef504d330e27e.jpg",
                "Blazer For Men Standard Fit", 2350.00);
        Product Mobile = new Product("Xiaomi Mi A1", "https://static-01.daraz.com.bd/p/ffb442b93163d6b6eb9883c150f0abe7.jpg",
                "Xiaomi Mi A1 - Smartphone - 5.5\" - 4GB RAM - 64GB ROM - 12MP Camera - Gold", 23000.50);
        Product Bike = new Product("Motorcycle", "https://static-01.daraz.com.bd/p/a1e887b9350e9cf9acd45b3747972ebd.jpg",
                "GPX Demon 150GR 150cc Motorcycle - White", 26500.00);
        Product Bike1 = new Product("Suzuki Gixxer", "https://static-01.daraz.com.bd/original/3d5fbadc876cbec076be088f0b3b581e.jpg",
                "Suzuki Gixxer 2016 (Single Disc) - Blue", 191950.00);
        Product Bike2 = new Product("Apache Motorcycle", "https://static-01.daraz.com.bd/p/f3aec87fa60918d20162bb49e9c00dfc.jpg",
                "Apache RTR 160CC Motor Cycle (SD) - Blue", 164900.00);
        Product Goggles = new Product("Under Water Goggles", "https://static-01.daraz.com.bd/p/d4642aa0cbc416568ae8f3ab9d855b85.jpg",
                "Swimming Goggles Women Men Swim Goggles Waterproof Suit HD Anti-Fog 100% UV Adjustable Prescription Glasses For Pools", 950.00);
        Product Boat = new Product("Air Boat", "https://static-01.daraz.com.bd/original/d3be265b702d897c79a720e09b3117df.jpg",
                "3 air chambers construction of the Boat", 4990.00);
        Product Ball = new Product("Swimming Ball", "https://static-01.daraz.com.bd/original/aa7aa4b817a32160025704e92559a681.jpg",
                "Swimming Ball - Orange and Black", 500.00);
        Product Television = new Product("Smart Television", "https://static-01.daraz.com.bd/p/46f7017fa60914ae844c6fb980104baa.jpg",
                "Full HD Internet TV 40'' - W652D - Black", 36500.50);
        Product Software = new Product("Adobe Photoshop", "https://static-01.daraz.com.bd/p/777c2c8202cb80d56b6481710e54bf42.jpg",
                "Adobe Photoshop CC 2019 [DVD]", 550.00);
        Product Software1 = new Product("Windows 10", "https://static-01.daraz.com.bd/p/2fe19352b097d0aa440b15eb7527dd05.jpg",
                "Windows _10 all Version (32 and 64 bit) _DVD_Bootable", 150.00);
        Product Gloves = new Product("Hand Batting Gloves", "https://static-01.daraz.com.bd/original/8522bb895762d676ff46a4522f39599b.jpg",
                "Cricket Bating Hand Gloves - White", 550.00);
        Product Ball1 = new Product("Crciket Ball", "https://static-01.daraz.com.bd/original/d9fd7b5306c8be15101e50fcd9445a0d.jpg",
                "Yourker Cricket Ball 6 Pcs - Red", 1160.00);
        Product Bat = new Product("Cricket Bat", "https://static-01.daraz.com.bd/original/80d5d286d05aa8e4a6491dc9bdd6ff0f.jpg",
                "Cricket Bat - Multi Color", 1170.50);
        Product Stump = new Product("Cricket Stump", "https://static-01.daraz.com.bd/p/9e6fd4dfceff8143ff53b11487810a10.jpg",
                "Cricket Plastic Stumps/Yellow,Blue", 500.50);


        profileProductList.add(Blazer);
        profileProductList.add(Mobile);
        profileProductList.add(Bike);
        profileProductList.add(Bike1);
        profileProductList.add(Bike2);
        profileProductList.add(Goggles);
        profileProductList.add(Boat);
        profileProductList.add(Ball);
        profileProductList.add(Television);
        profileProductList.add(Software);
        profileProductList.add(Software1);
        profileProductList.add(Gloves);
        profileProductList.add(Ball1);
        profileProductList.add(Bat);
        profileProductList.add(Stump);

    }

    public void readyHomeProductData() {
        Product watch = new Product("Rolex",
                "https://rolex.com/content/dam/rolex-58/homepage/roller-collection/baselworld/roller-static/homepage_new_yacht-master_42_0001_1050x825.jpg",
                "bla bla bla bal abla ", 120000.00);
        Product M3band = new Product("Band M3", "https://static-01.daraz.com.bd/p/47d726227604c332022cf74bd6103302.jpg",
                "Original Quality Band M3 Waterproof Smart Fitness Tracker -Black", 300.50);
        Product EarPhone = new Product("Ear Phone", "https://static-01.daraz.com.bd/p/8cb305648a9902737fd62b22ce375e5e.jpg",
                "original RM-510 remax in-ear touch-sensitive music telephone headset HD microphone for iphone, xiaomi and most smartphones", 265.50);
        Product USB = new Product("USB", "https://static-01.daraz.com.bd/p/933a959399b24a5aacb3905a49eb816d.jpg",
                "4 Port USB 2.0 Hub High Speed", 65.50);
        Product walet = new Product("Walet", "https://static-01.daraz.com.bd/original/f79c97cfc15a157fa6b0b114d0d7d0a9.jpg_200x200q80-product.jpg_.webp",
                "Full Leather", 800.00);
        Product Speaker = new Product("Mini Speaker", "https://static-01.daraz.com.bd/p/33de8169d4ab6a926992329d28bf84b6.jpg_200x200q80-product.jpg_.webp",
                "Original YX- X61 Bluetooth Mini Speaker -Black", 440.50);
        Product GlassProctector = new Product("Glass Protector", "https://static-01.daraz.com.bd/p/34ae679aacd36135a05388f085d08303.jpg_200x200q80-product.jpg_.webp",
                "Samsung Galaxy A20 - Original 9D Tempered Glass HD Screen Protector - Transparen", 250.00);
        Product Shoe = new Product("Sneaker Shoe", "https://static-01.daraz.com.bd/p/d925a947a488ee6ed3ee1e7285f662f2.jpg_200x200q80-product.jpg_.webp",
                "New Men’s Fashionable Fabrics Sneaker Shoes for Men", 2100.00);
        Product Belt = new Product("Belt", "https://static-01.daraz.com.bd/original/f352c4f5cbc783a40f9c4ee7d4bbee14.jpg_200x200q80-product.jpg_.webp",
                "Black Leather Formal Belt For Men", 500.50);
        Product Mobile = new Product("iPhone7", "https://images-na.ssl-images-amazon.com/images/I/31aH1WYy-IL._AC_US218_.jpg",
                "Apple iPhone 7, Verizon Unlocked, 32GB - Rose Gold - (Renewed)", 36550.50);
        Product Mobile1 = new Product("iPhone8", "https://images-na.ssl-images-amazon.com/images/I/41SAPsD0vUL._AC_US218_.jpg",
                "Apple iPhone 8, Verizon Unlocked, 256GB - Gray - (Renewed)", 46550.50);
        Product Mobile2 = new Product("Samsung 210", "https://images-na.ssl-images-amazon.com/images/I/41lJ6yZtIbL._AC_US218_.jpg",
                "Samsung Galaxy S10+ Plus G975F GSM Unlocked Smartphone (Renewed) (Prism White, 128GB)", 56800.00);
        Product Payel = new Product("Payel for Woman", "https://static-01.daraz.com.bd/p/20661b7376e6aeed21514a994c208e43.jpg",
                "Golden Metal Anklet (Payel) for Women", 1440.50);
        Product Shirt = new Product("T-Shirt", "https://static-01.daraz.com.bd/p/160e300d9f341a0b6d48686b59cd1e4b.jpg",
                "Shadow White T-shirts", 210.00);
        Product Camera = new Product("DSLR Camera", "https://static-01.daraz.com.bd/original/277abb123b844229271e621011a68189.jpg",
                "5D Mark IV DSLR Camera with 24-105mm IS II USM Lens - 30.4MP - Black", 210000.00);
        Product Suit = new Product("Men Suit", "https://static-01.daraz.com.bd/original/b0464bb9cdd14b4beebc8ec9f597d794.jpg",
                "Royal Blue Polyester Complete Suite For Men", 1500.50);

        homeproductList.add(watch);
        homeproductList.add(M3band);
        homeproductList.add(EarPhone);
        homeproductList.add(USB);
        homeproductList.add(walet);
        homeproductList.add(Speaker);
        homeproductList.add(GlassProctector);
        homeproductList.add(Shoe);
        homeproductList.add(Belt);
        homeproductList.add(Mobile);
        homeproductList.add(Mobile1);
        homeproductList.add(Mobile2);
        homeproductList.add(Payel);
        homeproductList.add(Shirt);
        homeproductList.add(Camera);
        homeproductList.add(Suit);

        mAdapter.notifyDataSetChanged();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        // listening to search query text change
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // filter recycler view when query submitted
                mAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // filter recycler view when text is changed
                mAdapter.getFilter().filter(query);
                return false;
            }
        });
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
