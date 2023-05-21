package com.fitorbit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class foodRecipe extends AppCompatActivity {

    TextView rN1, rN2, rN3, rN4, rN5, rI1, rI2, rI3, rI4, rI5, rP1, rP2, rP3, rP4, rP5;
    Switch cat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_recipe);

        rN1 = findViewById(R.id.repName1);
        rI1 = findViewById(R.id.repIngredients1);
        rP1 = findViewById(R.id.repProcess1);

        rN2 = findViewById(R.id.repName2);
        rI2 = findViewById(R.id.repIngredients2);
        rP2 = findViewById(R.id.repProcess2);

        rN3 = findViewById(R.id.repName3);
        rI3 = findViewById(R.id.repIngredients3);
        rP3 = findViewById(R.id.repProcess3);

        rN4 = findViewById(R.id.repName4);
        rI4 = findViewById(R.id.repIngredients4);
        rP4 = findViewById(R.id.repProcess4);

        rN5 = findViewById(R.id.repName5);
        rI5 = findViewById(R.id.repIngredients5);
        rP5 = findViewById(R.id.repProcess5);

        cat = findViewById(R.id.catSwitch);
        cat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cat.isChecked()){
                    rN1.setText("Name : Chicken breast");
                    rI1.setText("Ingredient : chicken, curd, red chili powder, turmeri powder, coriander powder, oil, salt");
                    rP1.setText("Process : Mix all the ingredient together except oil and let it marinate for 10 mintues. Add oil to the pan on medium heat. Add the mixture to it. Stir the mixture after every few mintues. Cook for approzimately 10 minutes. Serve and enjoy!");

                    rN2.setText("Name : Grilled Chicken with Quinoa Salad");
                    rI2.setText("Ingredient : 4 boneless, skinless chicken breasts, Salt and pepper to taste, 1 cup quinoa, 2 cups water, 1/2 cup cherry tomatoes halved, 1/2 cup cucumber diced, 1/4 cup red onion diced, 2 tbsp olive oil, 1 tbsp red wine vinegar, 1 tbsp lemon juice");
                    rP2.setText("Process : Preheat grill to medium-high heat. Season chicken breasts with salt and pepper and grill for 6-7 minutes per side, or until cooked through. Meanwhile, rinse quinoa and place in a pot with water. Bring to a boil, then reduce heat and simmer for 15 minutes, or until quinoa is tender and water is absorbed. In a large bowl, mix together cooked quinoa, cherry tomatoes, cucumber, and red onion. In a separate small bowl, whisk together olive oil, red wine vinegar, and lemon juice. Pour dressing over quinoa salad and toss to coat. Serve grilled chicken with quinoa salad on the side.");

                    rN3.setText("Name : Tuna Salad Stuffed Avocado");
                    rI3.setText("Ingredient : 2 ripe avocados, 1 can tuna, drained, 1/4 cup plain Greek yogurt, 2 tbsp chopped fresh parsley, 1 tbsp lemon juice, Salt and pepper to taste");
                    rP3.setText("Process : Cut avocados in half lengthwise and remove the pit.In a medium bowl, mix together tuna, Greek yogurt, parsley, lemon juice, salt, and pepper. Scoop tuna salad into avocado halves. Serve immediately.");

                    rN4.setText("Name : Lentil and Vegetable Soup");
                    rI4.setText("Ingredient : 1 cup lentils, 6 cups vegetable broth, 1 onion chopped, 2 garlic cloves minced, 2 carrots chopped, 2 celery stalks chopped, 1 cup chopped kale, 1 tsp dried thyme, Salt and pepper to taste");
                    rP4.setText("Process : inse lentils and place in a large pot with vegetable broth. Bring to a boil, then reduce heat and simmer for 20 minutes. Add onion, garlic, carrots, celery, kale, thyme, salt, and pepper to the pot. Simmer for an additional 20 minutes, or until vegetables are tender. Serve hot.");

                    rN5.setText("Name : Greek Yogurt Parfait");
                    rI5.setText("Ingredient : 1 cup plain Greek yogurt, 1/2 cup fresh berries (blueberries, strawberries, raspberries), 1/4 cup granola, 1 tbsp honey");
                    rP5.setText("Process : In a glass or bowl, layer Greek yogurt, berries, and granola. Drizzle honey on top. Serve immediately.");

                }
                else{
                    rN1.setText("Name : Lentil Curry");
                    rI1.setText("Ingredient : 1 cup dried lentils, 1 onion chopped, 2 cloves of garlic minced,1 tablespoon curry powder, 1 teaspoon ground cumin, 1 teaspoon ground coriander, 1 can coconut milk, 1 cup vegetable broth, 1 tablespoon olive oil, Salt and pepper to taste, Fresh cilantro for garnish");
                    rP1.setText("Process : Rinse the lentils and set aside. In a large pot, heat the olive oil over medium heat. Add the onion and garlic and sauté until translucent. Add the curry powder, cumin, and coriander to the pot and stir for about a minute. Add the lentils, coconut milk, and vegetable broth. Bring to a boil, then reduce heat and simmer for about 20-25 minutes, or until lentils are tender. Season with salt and pepper. Serve the lentil curry over rice or with naan bread. Garnish with fresh cilantro.");

                    rN2.setText("Name : Chickpea Salad");
                    rI2.setText("Ingredient : 2 cups cooked chickpeas, 1 cucumber diced, 1 red bell pepper diced ,1 small red onion finely chopped, 1 cup cherry tomatoes halved, 1/4 cup fresh parsley chopped, Juice of 1 lemon, 2 tablespoons olive oil, Salt and pepper to taste");
                    rP2.setText("Process : In a large bowl, combine chickpeas, cucumber, bell pepper, red onion, cherry tomatoes, and parsley. In a small bowl, whisk together lemon juice, olive oil, salt, and pepper. Pour the dressing over the salad and toss to combine. Serve chilled.");

                    rN3.setText("Name : Quinoa Stuffed Bell Peppers");
                    rI3.setText("Ingredient : 4 bell peppers (any color), 1 cup quinoa cooked, 1 can black beans rinsed and drained, 1 cup corn kernels, 1 small onion diced, 2 cloves of garlic minced, 1 teaspoon cumin, 1/2 teaspoon chili powder, Salt and pepper to taste, Shredded cheese (optional)");
                    rP3.setText("Process : Preheat the oven to 375°F (190°C). Cut the tops off the bell peppers and remove the seeds and membranes. Place the peppers in a baking dish. In a skillet, heat olive oil over medium heat. Add the onion and garlic, and sauté until softened. Add the cooked quinoa, black beans, corn, cumin, chili powder, salt, and pepper to the skillet. Stir until well combined and heated through. Spoon the quinoa mixture into the bell peppers, filling them to the top. If desired, sprinkle shredded cheese on top. Bake in the preheated oven for 25-30 minutes, or until the peppers are tender. Remove from the oven and let cool slightly before serving.");

                    rN4.setText("Name : Tofu Stir-Fry");
                    rI4.setText("Ingredient : 1 block of tofu pressed and cubed, 2 tablespoons soy sauce, 2 tablespoons hoisin sauce, 1 tablespoon sesame oil, 2 cloves of garlic minced, 1 tablespoon grated ginger, 1 bell pepper sliced, 1 cup broccoli florets, 1 carrot sliced, 1/2 cup snap peas, 2 green onions chopped, Sesame seeds for garnish");
                    rP4.setText("Process : In a bowl, whisk together soy sauce, hoisin sauce, sesame oil, garlic, and ginger. Set aside. Heat a tablespoon of oil in a large skillet or wok over medium-high heat. Add the tofu cubes to the skillet and cook until they are golden brown and crispy on all sides. Remove the tofu from the skillet and set aside. In the same skillet, add a little more oil if needed and sauté the bell pepper, broccoli, carrot, and snap peas until they are crisp-tender. Return the tofu to the skillet and pour the sauce over the tofu and vegetables. Stir to coat everything evenly and cook for an additional 2-3 minutes. Remove from heat and garnish with chopped green onions and sesame seeds. Serve the tofu stir-fry over cooked rice or noodles.");

                    rN5.setText("Name : Spinach and Chickpea Curry");
                    rI5.setText("Ingredient : 1 tablespoon vegetable oil, 1 onion chopped, 2 cloves of garlic minced, 1 teaspoon ground cumin, 1 teaspoon ground coriander, 1/2 teaspoon turmeric, 1/2 teaspoon paprika, 1/4 teaspoon cayenne pepper (optional), 1 can chickpeas rinsed and drained, 2 cups chopped spinach, 1 can diced tomatoes, 1/2 cup coconut milk, Salt and pepper to taste, Fresh cilantro for garnish");
                    rP5.setText("Process : Heat the vegetable oil in a large pan over medium heat. Add the chopped onion and sauté until it becomes translucent. Add the minced garlic, ground cumin, ground coriander, turmeric, paprika, and cayenne pepper. Stir and cook for about 1 minute to release the flavors. Add the chickpeas, chopped spinach, diced tomatoes (with their juice), and coconut milk to the pan. Stir well to combine. Reduce the heat to low, cover the pan, and simmer for about 15 minutes, stirring occasionally. Season with salt and pepper to taste. Serve the spinach and chickpea curry over cooked rice or with naan bread. Garnish with fresh cilantro.");
                }
            }
        });
    }
}