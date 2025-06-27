package org.example.practice;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamQuestions {
    public static void main(String[] args) {

        //1. Create an Immutable list using Streams
        var immutable = Stream.of(3, 5, 6, 2, 11, 15, 8, 19, null).toList();
        System.out.println(immutable);
//        immutable.add(56); throws UnsupportedOperation exception as toList() will always create immutable list
        System.out.println(immutable);

        //2. Create Modifiable list using Streams
        var modifiable = Stream.of(12, 22, 15, 8, 6, 11, 17, 30, null).collect(Collectors.toList());
        System.out.println(modifiable);
        modifiable.add(78);
        System.out.println(modifiable);

        //3. Custom class
        record Product(String name, String category, int price) {};

        //Group Products by category
        Stream<Product> products = Stream.of(
                new Product("TV", "Entertainment", 20000),
                new Product("Netflix", "Entertainment", 5000),
                new Product("Fridge", "Electronics", 30000),
                new Product("Sofa", "Furniture", 15000),
                new Product("Bed", "Furniture", 50000),
                new Product("Laptop", "Electronics", 90000)
        );
        Map<String, List<Product>> groupedByCategory = products.collect(Collectors.groupingBy(Product::category));
        System.out.println(groupedByCategory);

        //4. Calculate the total price by category
        Stream<Product> products2 = Stream.of(
                new Product("TV", "Entertainment", 20000),
                new Product("Netflix", "Entertainment", 5000),
                new Product("Fridge", "Electronics", 30000),
                new Product("Sofa", "Furniture", 15000),
                new Product("Bed", "Furniture", 50000),
                new Product("Laptop", "Electronics", 90000)
        );
        Map<String, Integer> totalPriceByCategory = products2.collect(Collectors.groupingBy(Product::category, Collectors.summingInt(Product::price)));
        System.out.println(totalPriceByCategory);

        //5. Calculate the average price by category
        Stream<Product> products3 = Stream.of(
                new Product("TV", "Entertainment", 20000),
                new Product("Netflix", "Entertainment", 5000),
                new Product("Fridge", "Electronics", 30000),
                new Product("Sofa", "Furniture", 15000),
                new Product("Bed", "Furniture", 50000),
                new Product("Laptop", "Electronics", 90000)
        );
        Map<String, Double> avgPriceByCategory = products3.collect(Collectors.groupingBy(Product::category, Collectors.averagingInt(Product::price))); //avg always returns Double
        System.out.println(avgPriceByCategory);

        //6. Counting of products by category
        Stream<Product> products4 = Stream.of(
                new Product("TV", "Entertainment", 20000),
                new Product("Netflix", "Entertainment", 5000),
                new Product("Fridge", "Electronics", 30000),
                new Product("Sofa", "Furniture", 15000),
                new Product("Bed", "Furniture", 50000),
                new Product("Laptop", "Electronics", 90000)
        );

        Map<String, Long> countingOfProductsByCategory = products4.collect(Collectors.groupingBy(Product::category, Collectors.counting()));
        System.out.println(countingOfProductsByCategory);

        //7. Products with price > 10000
        Stream<Product> products5 = Stream.of(
                new Product("TV", "Entertainment", 20000),
                new Product("Netflix", "Entertainment", 5000),
                new Product("Fridge", "Electronics", 30000),
                new Product("Sofa", "Furniture", 15000),
                new Product("Bed", "Furniture", 50000),
                new Product("Laptop", "Electronics", 90000)
        );
//
//        List<Product> productsGreaterThanTenThousand = products5.filter(product -> product.price() > 10000).collect(Collectors.toList());
//        System.out.println(productsGreaterThanTenThousand);

        Map<String, Integer> productsGreaterThanTenThousand2 = products5.filter(product -> product.price() > 10000).collect(Collectors.toMap(Product::name, Product::price));
        System.out.println(productsGreaterThanTenThousand2);

        //8. Extracting the Product names
        Stream<Product> products6 = Stream.of(
                new Product("TV", "Entertainment", 20000),
                new Product("Netflix", "Entertainment", 5000),
                new Product("Fridge", "Electronics", 30000),
                new Product("Sofa", "Furniture", 15000),
                new Product("Bed", "Furniture", 50000),
                new Product("Laptop", "Electronics", 90000)
        );
        List<String> productNames = products6.map(Product::name).collect(Collectors.toList());
        System.out.println(productNames);

        //9. Partitioning : Separate products into Expensive and Cheap
        Stream<Product> products7 = Stream.of(
                new Product("TV", "Entertainment", 20000),
                new Product("Netflix", "Entertainment", 5000),
                new Product("Fridge", "Electronics", 30000),
                new Product("Sofa", "Furniture", 15000),
                new Product("Bed", "Furniture", 50000),
                new Product("Laptop", "Electronics", 90000)
        );

        Map<Boolean, List<Product>> expensiveProducts = products7.collect(Collectors.partitioningBy(p -> p.price() > 5000));
        System.out.println(expensiveProducts);

        //10 Using Summary statistics for Product Prices
        //Sum, average, min, max, count (5 metrics)
        Stream<Product> products8 = Stream.of(
                new Product("TV", "Entertainment", 20000),
                new Product("Netflix", "Entertainment", 5000),
                new Product("Fridge", "Electronics", 30000),
                new Product("Sofa", "Furniture", 15000),
                new Product("Bed", "Furniture", 50000),
                new Product("Laptop", "Electronics", 90000)
        );

        Map<String, IntSummaryStatistics> summary = products8.collect(Collectors.groupingBy(Product::category, Collectors.summarizingInt(Product::price)));
        System.out.println(summary);

    }
}
