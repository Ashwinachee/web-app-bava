package com.example.placementpreparationapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DBMSTopicNotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dbms_topic_notes);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize TextViews
        TextView dbmsTopicTitle = findViewById(R.id.dbmsTopicTitle);
        TextView dbmsTopicContent = findViewById(R.id.dbmsTopicContent);

        // Get selected topic
        String topic = getIntent().getStringExtra("topic");
        if (topic == null) {
            topic = "DBMS";
        }

        // Set topic title
        dbmsTopicTitle.setText(topic);

        // Display notes
        if (topic.equals("DBMS Basics")) {
            dbmsTopicContent.setText(
                    "DATABASE MANAGEMENT SYSTEM (DBMS)\n\n" +
                            "A DBMS is software used to create, store, organize and manage data in a database.\n\n" +
                            "Examples:\n• MySQL\n• Oracle\n• PostgreSQL\n• SQL Server\n\n" +
                            "Advantages of DBMS:\n\n" +
                            "• Reduces data redundancy\n• Provides data security\n• Maintains data consistency\n• Supports data sharing\n• Provides backup and recovery\n\n" +
                            "DBMS vs File System:\n\n" +
                            "DBMS provides better security, concurrency control and data management than traditional file systems.\n\n" +
                            "Important Placement Question:\n\n" +
                            "What is the difference between DBMS and RDBMS?\n\n" +
                            "DBMS manages data as files or collections, while RDBMS stores data in related tables using rows and columns."
            );
        } else if (topic.equals("ER Model")) {
            dbmsTopicContent.setText(
                    "ENTITY RELATIONSHIP (ER) MODEL\n\n" +
                            "The ER model is used to represent the structure of a database visually.\n\n" +
                            "Main Components:\n\n" +
                            "1. Entity\nA real-world object.\n\nExample: Student, Employee, Product\n\n" +
                            "2. Attribute\nA property of an entity.\n\nExample: Student ID, Name, Email\n\n" +
                            "3. Relationship\nShows the connection between entities.\n\nExample:\nStudent ENROLLS in Course.\n\n" +
                            "Types of Relationships:\n\n" +
                            "• One-to-One\n• One-to-Many\n• Many-to-One\n• Many-to-Many"
            );
        } else if (topic.equals("Keys")) {
            dbmsTopicContent.setText(
                    "DATABASE KEYS\n\n" +
                            "Keys are used to identify records and establish relationships between tables.\n\n" +
                            "1. Primary Key\n\nUniquely identifies each record in a table.\nIt cannot contain NULL values.\n\nExample:\nStudent_ID\n\n" +
                            "2. Foreign Key\n\nA field that refers to the primary key of another table.\n\n" +
                            "3. Candidate Key\n\nA minimal set of attributes that can uniquely identify a record.\n\n" +
                            "4. Super Key\n\nA set of one or more attributes that uniquely identifies a record.\n\n" +
                            "5. Composite Key\n\nA key made using two or more attributes."
            );
        } else if (topic.equals("Normalization")) {
            dbmsTopicContent.setText(
                    "DATABASE NORMALIZATION\n\n" +
                            "Normalization is the process of organizing data to reduce data redundancy and improve data consistency.\n\n" +
                            "Main Normal Forms:\n\n" +
                            "1NF - First Normal Form\n\nEach column must contain atomic values.\n\n" +
                            "2NF - Second Normal Form\n\nTable must be in 1NF and should not have partial dependency.\n\n" +
                            "3NF - Third Normal Form\n\nTable must be in 2NF and should not have transitive dependency.\n\n" +
                            "BCNF\n\nA stronger version of 3NF.\n\n" +
                            "Main Goal:\n\nReduce redundancy and avoid insertion, deletion and update anomalies."
            );
        } else if (topic.equals("Transactions")) {
            dbmsTopicContent.setText(
                    "DATABASE TRANSACTIONS\n\n" +
                            "A transaction is a sequence of operations performed as a single logical unit of work.\n\n" +
                            "Example:\n\nBank Account Transfer\n\n1. Deduct money from Account A.\n2. Add money to Account B.\n\nBoth operations must be completed successfully.\n\n" +
                            "Transaction States:\n\n• Active\n• Partially Committed\n• Committed\n• Failed\n• Aborted\n\n" +
                            "COMMIT permanently saves the changes.\n\nROLLBACK removes changes made by the transaction."
            );
        } else if (topic.equals("ACID Properties")) {
            dbmsTopicContent.setText(
                    "ACID PROPERTIES\n\n" +
                            "ACID properties ensure reliable database transactions.\n\n" +
                            "A - Atomicity\n\nA transaction is completed completely or not at all.\n\n" +
                            "C - Consistency\n\nThe database remains in a valid state before and after a transaction.\n\n" +
                            "I - Isolation\n\nMultiple transactions can execute without interfering with each other.\n\n" +
                            "D - Durability\n\nOnce a transaction is committed, its changes are permanently stored."
            );
        } else if (topic.equals("Indexing")) {
            dbmsTopicContent.setText(
                    "DATABASE INDEXING\n\n" +
                            "An index is a data structure used to speed up data retrieval from a database table.\n\n" +
                            "Without an index:\n\nThe database may need to scan many rows.\n\n" +
                            "With an index:\n\nThe database can find required data faster.\n\n" +
                            "Common Index Types:\n\n• B-Tree Index\n• Hash Index\n• Clustered Index\n• Non-Clustered Index\n\n" +
                            "Disadvantage:\n\nIndexes require additional storage and may slow down INSERT, UPDATE and DELETE operations."
            );
        } else if (topic.equals("SQL")) {
            dbmsTopicContent.setText(
                    "STRUCTURED QUERY LANGUAGE (SQL)\n\n" +
                            "SQL is used to communicate with relational databases.\n\n" +
                            "Main SQL Commands:\n\n" +
                            "DDL - Data Definition Language\n\nCREATE\nALTER\nDROP\nTRUNCATE\n\n" +
                            "DML - Data Manipulation Language\n\nINSERT\nUPDATE\nDELETE\n\n" +
                            "DQL - Data Query Language\n\nSELECT\n\n" +
                            "DCL - Data Control Language\n\nGRANT\nREVOKE\n\n" +
                            "TCL - Transaction Control Language\n\nCOMMIT\nROLLBACK\nSAVEPOINT"
            );
        } else if (topic.equals("SQL Joins")) {
            dbmsTopicContent.setText(
                    "SQL JOINS\n\n" +
                            "Joins are used to combine data from two or more tables.\n\n" +
                            "1. INNER JOIN\n\nReturns only matching records from both tables.\n\n" +
                            "2. LEFT JOIN\n\nReturns all records from the left table and matching records from the right table.\n\n" +
                            "3. RIGHT JOIN\n\nReturns all records from the right table and matching records from the left table.\n\n" +
                            "4. FULL OUTER JOIN\n\nReturns all records from both tables.\n\n" +
                            "5. SELF JOIN\n\nA table is joined with itself.\n\n" +
                            "Placement Tip:\n\nBe prepared to explain the difference between INNER JOIN, LEFT JOIN, RIGHT JOIN and FULL JOIN."
            );
        }
    }
}
