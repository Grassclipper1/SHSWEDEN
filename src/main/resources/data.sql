    INSERT
    INTO
        "user"
        (first_Name, Last_Name, User_Name, PassWord, Email_Address, Street_Address, zip_id)
    VALUES
        ('Test', 'Testsson','Gurkan', 'banan', 'test@test.com', 'karlavägen', '3333');

    INSERT
    INTO
        listing
        (title, description, price, "date", seller_id, category_id, donation_percent, donation_id)
    VALUES
        ('Skor', 'Hej jag vill sälja min sko', 100, CURRENT_TIMESTAMP, 1, 1, 10, 1);

         INSERT
            INTO
                listing
                (title, description, price, "date", seller_id, category_id, donation_percent, donation_id)
            VALUES
                ('Kalsonger', 'Välanvända kalsonger, några hål', 450, CURRENT_TIMESTAMP, 1, 1, 10, 1);


    INSERT
    INTO
      feedback
      (feedback_message, listing_id, rating)
    VALUES
      ('Very good seller', 1, 10);

