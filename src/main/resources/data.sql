    INSERT
    INTO
        "user"
        (first_Name, Last_Name, User_Name, PassWord, Email_Address, Street_Address, zip_id)
    VALUES
        ('Test', 'Testsson','Gurkan', 'banan', 'test@test.com', 'karlavägen', '3333');

    INSERT
    INTO
        "user"
         (first_Name, Last_Name, User_Name, PassWord, Email_Address, Street_Address, zip_id)
    VALUES
        ('Kalle', 'Karlsson','LillFlugan', 'melon', 'Kalle@Karlsson.com', 'Drottninggatan', '55555');

   INSERT
    INTO
        "user"
         (first_Name, Last_Name, User_Name, PassWord, Email_Address, Street_Address, zip_id)
    VALUES
        ('Stina', 'Olsson','Vårblomman', 'sommar', 'Stina@Olsson.com', 'Örtgatan', '32434');

   INSERT
    INTO
        "user"
         (first_Name, Last_Name, User_Name, PassWord, Email_Address, Street_Address, zip_id)
    VALUES
        ('Kal', 'P.Dal','BuffaloBill', 'ängel', 'Kal@PDal.com', 'Ystadvägen', '21464');


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
                ('Kalsonger', 'Välanvända kalsonger, några hål', 450, CURRENT_TIMESTAMP, 2, 1, 10, 2);

 INSERT
    INTO
        listing
        (title, description, price, "date", seller_id, category_id, donation_percent, donation_id)
    VALUES
        ('Gitarr', 'Akustisk gitarr, stålsträngad. Några repor. Fenderkopia. ', 800, CURRENT_TIMESTAMP, 4, 1, 10, 3);

    INSERT
       INTO
           listing
           (title, description, price, "date", seller_id, category_id, donation_percent, donation_id)
       VALUES
           ('Hörlurar', 'Boze hörlurar, säjer pga lyxfällan', 999, CURRENT_TIMESTAMP, 4, 1, 10, 4);

      INSERT
         INTO
             listing
             (title, description, price, "date", seller_id, category_id, donation_percent, donation_id)
         VALUES
             ('Porslinkoppar', 'Fyra koppar av märket petunia', 75, CURRENT_TIMESTAMP, 3, 1, 10, 5);

  INSERT
         INTO
             listing
             (title, description, price, "date", seller_id, category_id, donation_percent, donation_id)
         VALUES
             ('Lego', 'Säljer lego då min son inte leker med det längre', 300, CURRENT_TIMESTAMP, 3, 1, 10, 6);
  INSERT
         INTO
             listing
             (title, description, price, "date", seller_id, category_id, donation_percent, donation_id)
         VALUES
             ('Smart-tv', 'En samsung smart-tv, aldrig använd.', 5000, CURRENT_TIMESTAMP, 4, 1, 5, 7);
  INSERT
         INTO
             listing
             (title, description, price, "date", seller_id, category_id, donation_percent, donation_id)
         VALUES
             ('Soffa', 'Fin tvåsitsig soffa, av ikea', 200, CURRENT_TIMESTAMP, 2, 1, 10, 8);

    INSERT
    INTO
      feedback
      (feedback_message, listing_id, rating)
    VALUES
      ('Very good seller', 1, 10);

