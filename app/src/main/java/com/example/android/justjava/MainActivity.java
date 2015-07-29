package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

Integer quantity = 1; //global quantity.  used in increment and decrement

    /**
     * This method is called when the order button is clicked.
     */

    public void increment(View view) {
        quantity ++;
        Log.d("increment", quantity.toString());
        display();
        displayPrice();
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void decrement(View view) {
        if (quantity > 0) {
            quantity--;
            Log.d("decrement", quantity.toString());
            display();
            displayPrice();
        }
    }


    /*
 * Create summary of order
 * @param price of order
 * @return String containing order summary
 * */

    private String createOrderSummary(int price)
    {
        String summary;
        summary = "Name:   Jae Nwawe";
        summary += "\nCoffees: " + quantity;
        summary += "\nTotal: $ " + calculatePrice();
        summary += "\nThank You";
        return summary;
    }

     /*
     * Calculates the price of the order
     * @return price of coffee which is amount times quanitity
     **/
    public Integer calculatePrice()  {
        Integer amount= 5 * quantity;
        Log.d("calculatePrice", amount.toString());
        return amount;
    }


     //This method is called when the order button is clicked.

    public void submitOrder(View view) {
        displayMessage(createOrderSummary(calculatePrice()));

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


//Display Quantity

    private void display() {
        TextView textQuantity = (TextView) findViewById(R.id.quantity_text_view);
        textQuantity.setText(quantity.toString());
        Log.d("display", quantity.toString());
    }


//Display Price

    private void displayPrice() {
        TextView textPrice = (TextView) findViewById(R.id.total_text_view);
        textPrice.setText("$ "+ calculatePrice().toString());
    }

//This method displays the given text on the screen.

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}
