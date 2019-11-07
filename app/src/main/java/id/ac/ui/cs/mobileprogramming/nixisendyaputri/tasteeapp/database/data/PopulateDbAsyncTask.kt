package id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.database.data
import android.os.AsyncTask
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.R
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.database.RecipeDatabase
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.database.entity.RecipeMenu

class PopulateDbAsyncTask(db: RecipeDatabase?) : AsyncTask<Unit, Unit, Unit>() {
    private val recipeDao = db?.recipeDao()

    override fun doInBackground(vararg p0: Unit?) {
        recipeDao?.insert(
            RecipeMenu(
                id = 0,
                imageResId = R.drawable.all_recipe1,
                name = "Summer Pasta Primavera",
                rating = "4.6",
                total_cook_time = "30 min",
                prep_time = "10 min",
                cook_time = "20 min",
                difficulty = "easy",
                servings = "2 pp",
                videoId = "PekQ6PMX_Lc",
                ingredientList = "1-1/4 lbs (2 pints) cherry or grape tomatoes, halved\n" +
                        "4 shallots, thinly sliced\n" +
                        "5 cloves garlic, peeled and smashed\n" +
                        "1/4 cup extra virgin olive oil, plus more for serving\n" +
                        "2 teaspoons salt\n" +
                        "1-1/2 teaspoons sugar",
                instructionList = "Preheat the oven to 450°F. Line a baking sheet with heavy duty aluminum foil.\n\n" +
                        "Combine the tomatoes, shallots, garlic, olive oil, salt, and sugar on the prepared baking sheet. Toss with your hands or a rubber spatula until the vegetables are evenly coated. Arrange the vegetables in a single layer and roast for 15 to 20 minutes, or until the tomatoes are just starting to brown. Remove the pan from the oven and add the zucchini and corn. Toss with a rubber spatula (the tomatoes will collapse; that's okay) and spread into and even layer. Roast for 5 minutes more, until the zucchini and corn are tender-crisp.\n\n" +
                        "Meanwhile, cook the pasta in salted water until al dente. Drain, then add the pasta back to the pan. Add the roasted vegetables and all their juices to the pasta, along with the butter, herbes de Provence, red pepper flakes, Pecorino Romano, basil, and pine nuts. Toss well, then taste and adjust seasoning if necessary. Spoon into pasta bowls and drizzle with olive oil, if desired. Serve with more grated cheese."
            )
        )
        recipeDao?.insert(
            RecipeMenu(
                id = 0,
                imageResId = R.drawable.all_recipe2,
                name = "Juicy Steakhouse Burgers",
                rating = "4.8",
                total_cook_time = "35 min",
                prep_time = "10 min",
                cook_time = "25 min",
                difficulty = "hard",
                servings = "3 pp",
                videoId = "eUyFdILO6ik" ,
                ingredientList = "2 pieces white sandwich bread, crusts removed and cut into 1/4-inch pieces\n" +
                        "1/3 cup low fat milk\n" +
                        "2-1/2 teaspoons kosher salt\n" +
                        "1 teaspoon freshly ground black pepper\n" +
                        "3 garlic cloves, minced\n" +
                        "1-1/2 tablespoons Worcestershire sauce\n" +
                        "2 tablespoons ketchup\n" +
                        "3 pounds 85% lean ground beef\n" +
                        "3 scallions, finely sliced (optional)\n" +
                        "Non-flammable cooking spray to grease grill\n" +
                        "10 hamburger buns",
                instructionList = "Preheat the grill to high heat.\n" +
                        "In a large bowl, mash the bread and milk together with a fork until it forms a chunky paste. Add the salt, pepper, garlic, Worcestershire sauce and ketchup and mix well.\n" +
                        "Add the ground beef and scallions and break the meat up with your hands. Gently mix everything together until just combined. Do not overmix. Divide the mixture into ten equal portions and form loose balls. Flatten the balls into 3/4-inch patties about 4-1/2 inches across. Form a slight depression in the center of each patty to prevent the burgers from puffing up on the grill.\n" +
                        "Grease the grill with non-flammable cooking spray. Grill the burgers, covered, until nicely browned on the first side, 2-4 minutes. Flip burgers and continue cooking for a few minutes more until desired doneness is reached. Before serving, toast the buns on the cooler side of the grill if desired."
            )
        )
        recipeDao?.insert(
            RecipeMenu(
                id = 0,
                imageResId = R.drawable.all_recipe3,
                name = "Chicken Curry",
                rating = "4.4",
                total_cook_time = "40 min",
                prep_time = "10 min",
                cook_time = "30 min",
                difficulty = "hard",
                servings = "2 pp",
                videoId = "WRYOVVexMhU",
                ingredientList = "1-1/4 pounds boneless, skinless chicken breasts, cut into 1/4-inch strips\n" +
                        "Salt and freshly ground black pepper\n" +
                        "2-1/2 teaspoons curry powder, divided\n" +
                        "3 tablespoons vegetable oil, divided\n" +
                        "1 medium yellow onion, finely chopped\n" +
                        "4 garlic cloves, minced\n" +
                        "1 tablespoon grated fresh ginger\n" +
                        "2 cups low sodium chicken broth, best quality such as Swanson\n" +
                        "1 tablespoon cornstarch\n" +
                        "2 teaspoons sugar\n" +
                        "1 cup frozen peas (no need to thaw)\n" +
                        "1/4 cup plain low fat (2%) or whole Greek yogurt (do not use nonfat)\n" +
                        "1/4 cup chopped fresh cilantro",
                instructionList = "Sprinkle the chicken evenly with 3/4 teaspoon salt, 1/4 teaspoon pepper and 1 teaspoon curry powder.\n" +
                        "Heat 1-1/2 tablespoons of oil in a 12-inch skillet over high heat until just smoking. Add the chicken in a single layer and cook, stirring occasionally, until lightly browned but still pink in spots, about 3 minutes. Transfer the partially cooked chicken to a clean bowl and set aside.\n" +
                        "Add the remaining 1-1/2 tablespoons oil to the skillet and set heat to medium. Add the onions and cook, stirring occasionally, until softened, about 5 minutes. Stir in the garlic, ginger and remaining 1-1/2 teaspoons curry powder and cook until fragrant, about a minute more.\n" +
                        "Whisk the chicken broth and cornstarch together to dissolve the cornstarch, then add to the skillet along with the sugar and 1/8 teaspoon salt. Bring to a boil, then reduce the heat to medium and cook until the sauce is nicely thickened, about 5 minutes.\n" +
                        "Add the peas and partially cooked chicken to the skillet, turn the heat down to low and simmer until the chicken is cooked through, a few minutes. Off the heat, stir in the yogurt and cilantro; then season with salt and pepper, to taste. Serve with basmati rice."
            )
        )
        recipeDao?.insert(
            RecipeMenu(
                id = 0,
                imageResId = R.drawable.all_recipe4,
                name = "Baja Fish Tacos",
                rating = "4.5",
                total_cook_time = "35 min",
                prep_time = "10 min",
                cook_time = "25 min",
                difficulty = "easy",
                servings = "4 pp",
                videoId = "qDFqRxeEn9o",
                ingredientList = "1-1/2 pounds skinless cod, cut into 1-inch wide x 4-inch long strips\n" +
                        "Vegetable oil, for frying\n" +
                        "12 (6-inch) soft corn tortillas, warmed\n" +
                        "Lime wedges, for serving",
                instructionList = "Toss the cabbage, red onion, cilantro, vinegar, oil and salt together in a medium bowl and set aside.\n" +
                        "Combine the mayonnaise, lime juice, chipotle chiles with sauce and garlic in a blender or mini food processor and blend until smooth. Set aside.\n" +
                        "Mix the flour, salt and pepper together in a medium bowl. Gradually add the beer, whisking until the batter is smooth with no lumps. Set aside.\n" +
                        "In a medium skillet, over medium heat, add enough oil to reach a depth of 1/2-inch. Heat the oil until a deep-fry thermometer registers 350 degrees F, or when the end of a wooden spoon sizzles when dipped into the oil."
            )
        )
        recipeDao?.insert(
            RecipeMenu(
                id = 0,
                imageResId = R.drawable.all_recipe5,
                name = "Green Salad",
                rating = "4.4",
                total_cook_time = "20 min",
                prep_time = "15 min",
                cook_time = "5 min",
                difficulty = "easy",
                servings = "3 pp",
                videoId = "QTTDv9Y89SY",
                ingredientList = "1 large head romaine lettuce (or 3 hearts), washed, dried and cut into large, bite-sized pieces\n" +
                        "1 large red bell pepper, chopped\n" +
                        "1 cup seeded and chopped hothouse cucumbers\n" +
                        "1 to 2 carrots, peeled into ribbons\n" +
                        "Handful grape tomatoes, halved\n" +
                        "Handful pitted olives\n" +
                        "Ricotta Salata (see note) or Feta, crumbled to taste",
                instructionList = "Make the dressing: Combine all dressing ingredients in a food processor and blitz to blend.\n" +
                        "Place all of the salad ingredients except for the cheese in a large bowl. Right before serving, add about half of the dressing and toss well. Add more dressing little by little as necessary; be sure to dress greens very generously, otherwise salad will be bland. Toss in the cheese, then taste and adjust seasoning with salt and pepper, if necessary.\n" +
                        "Note: Ricotta salata is an Italian sheep's milk cheese that has a salty, slightly tangy flavor, almost like a dry Italian feta. It is not the same as the wet ricotta in the tub. You can find it at Whole Foods, gourmet grocers or specialty cheese shops."
            )
        )
        recipeDao?.insert(
            RecipeMenu(
                id = 0,
                imageResId = R.drawable.all_recipe6,
                name = "Strawberry Shortcake",
                rating = "4.7",
                total_cook_time = "35 min",
                prep_time = "10 min",
                cook_time = "25 min",
                difficulty = "easy",
                servings = "2 pp",
                videoId = "K92T3uc75bM",
                ingredientList = "2 cups all-purpose flour, spooned into measuring cup and leveled-off\n" +
                        "3 tablespoons cornstarch\n" +
                        "1 tablespoon baking powder\n" +
                        "1/4 teaspoon baking soda\n" +
                        "2 tablespoons granulated sugar\n" +
                        "1 teaspoon salt\n" +
                        "10 tablespoons cold unsalted butter, cut into 1/2-inch chunks\n" +
                        "3/4 cup buttermilk (see note below)\n" +
                        "2 tablespoons turbinado sugar",
                instructionList = "Preheat the oven to 425°F and set an oven rack in the middle position. Line a 13x18-in baking sheet with parchment paper.\n" +
                        "In a large bowl, whisk together the flour, cornstarch, baking powder, baking soda, granulated sugar, and salt.\n" +
                        "Add the pieces of cold butter. Use your fingertips to rub the butter into the dry ingredients until the mixture resembles coarse crumbs with pea-sized clumps of butter within. Add the buttermilk and stir with a rubber spatula until the dough comes together into a sticky, shaggy mass. Do not overmix."
            )
        )
    }
}