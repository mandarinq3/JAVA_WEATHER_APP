        // String inputDate = "2023/02/23";("yyyy/MM/dd")
        // SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
        
        
        String inputDate = "2023-02-23";
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

        Date dt1 = null;
        try {
            dt1 = format1.parse(inputDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        DateFormat format2 = new SimpleDateFormat("EEEE");
        String finalDay = format2.format(dt1);

        System.out.println(finalDay);