package com.example.expt2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Expenses : AppCompatActivity() {

    // Declarations
    private lateinit var SpendingBlock: TextView
    private lateinit var TotalSpent: TextView
    private lateinit var tvAmt: TextView
    private lateinit var rvExpenses: RecyclerView

    // Array of expenses
    val expenses = arrayOf(
        Expense("Groceries", 250.00, "Food"),
        Expense("Netflix", 169.00, "Entertainment"),
        Expense("Uber", 85.00, "Transport")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expense)

        // Link views to XML
        SpendingBlock = findViewById<TextView>(R.id.SpendingBlock)
        TotalSpent = findViewById<TextView>(R.id.TotalSpent)
        tvAmt = findViewById<TextView>(R.id.tvAmt)
        rvExpenses = findViewById<RecyclerView>(R.id.rvExpenses)

        rvExpenses.layoutManager = LinearLayoutManager(this)
        rvExpenses.adapter = ExpenseAdapter(expenses)

        // Loop through expenses and add up the total
        var total = 0.0
        for (expense in expenses) {
            total += expense.amount
        }

        // Display the total
        tvAmt.text = "R ${"%.2f".format(total)}"
    }
}

data class Expense(
    val description: String,
    val amount: Double,
    val category: String
)