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
        (title, description, price, "date", seller_id, category_id, shipping_cost, donation_percent, donation_org)
    VALUES
        ('Skor', 'Hej jag vill sälja mina skor', 100, '2023-01-22', 1, 4265, 49.0, 10, 'Rädda Barnen');


 INSERT
    INTO
        listing
        (title, description, price, "date", seller_id, category_id, shipping_cost, donation_percent, donation_org)
    VALUES
        ('Gitarr', 'Akustisk gitarr, stålsträngad. Några repor. Fender-kopia. ', 800, '2023-01-15', 4, 3680, 100.0, 10, 'Unicef');

    INSERT
       INTO
           listing
           (title, description, price, "date", seller_id, category_id, shipping_cost, donation_percent, donation_org)
       VALUES
           ('Hörlurar', 'Boze hörlurar, säjer pga lyxfällan', 999, '2023-01-13', 4, 2853, 150.0, 10, 'Röda Korset');

      INSERT
         INTO
             listing
             (title, description, price, "date", seller_id, category_id, shipping_cost, donation_percent, donation_org)
         VALUES
             ('Porslinkoppar', 'Fyra koppar av märket petunia', 75, '2023-01-28', 3, 2491, 49.0, 10, 'WWF');

  INSERT
         INTO
             listing
             (title, description, price, "date", seller_id, category_id, shipping_cost, donation_percent, donation_org)
         VALUES
             ('Lego', 'Säljer lego då min son inte leker med det längre', 300, '2023-01-28', 3, 573, 29.0, 10, 'WWF');
  INSERT
         INTO
             listing
             (title, description, price, "date", seller_id, category_id, shipping_cost, donation_percent, donation_org)
         VALUES
             ('Smart-tv', 'En samsung smart-tv, aldrig använd.', 5000, '2023-01-29', 4, 2917, 400.0, 5, 'Cancerfonden');
  INSERT
         INTO
             listing
             (title, description, price, "date", seller_id, category_id, shipping_cost, donation_percent, donation_org)
         VALUES
             ('Soffa', 'Fin tvåsitsig soffa, ikea', 200, '2023-01-30', 2, 128, 50.0, 10, 'Cancerfonden');
























    INSERT
    INTO
      feedback
      (feedback_message, listing_id, rating)
    VALUES
      ('Very good seller', 1, 10);

  INSERT
         INTO
             purchase
             (item_name, seller_id, buyer_id, price, donation_sum)
         VALUES
             ('Testsak', 1, 2, 15000, 74);

   INSERT
          INTO
              purchase
              (item_name, seller_id, buyer_id, price, donation_sum)
          VALUES
              ('testsak2', 1, 2, 374956, 83);