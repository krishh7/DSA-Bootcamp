package org.example.java8features.streams;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCodeSamples {
    public static void main(String[] args) {

        //1. Immutable List, allow nulls
        var immutable = Stream.of("Red", "Green", "Blue", "White", "Black", null).toList();
        System.out.println(immutable);
//        immutable.add("Pen"); //Throws UnsupportedOperationException

        //2. Modifiable List, allows nulls
        var modifiable = Stream.of("Red", "Pink", "Yellow", null).collect(Collectors.toList());
        System.out.println(modifiable);
        modifiable.add("Maroon");
        System.out.println(modifiable);
        modifiable.set(3, "Green");
        System.out.println(modifiable);
        //so with Collect(Collectors.toList()) you can modify and update the list.

        //prerequisite
        record Product (String name, String category, int price) {

        };
        Stream<Product> products = Stream.of(
                new Product("Laptop", "Electronics", 10000),
                new Product("TV", "Electronics", 10000),
                new Product("Sofa", "Furniture", 20000),
                new Product("Bed", "Furniture", 20000),
                new Product("Fridge", "Electronics", 10000)
        );

        //3. Grouping Products by Category
        Map<String, List<Product>> groupProductsByCategory = products.collect(Collectors.groupingBy(Product::category));
        System.out.println(groupProductsByCategory);

        //4. Aggregation : Calculating the total price

        Stream<Product> products2 = Stream.of(
                new Product("Laptop", "Electronics", 10000),
                new Product("TV", "Electronics", 10000),
                new Product("Sofa", "Furniture", 20000),
                new Product("Bed", "Furniture", 20000),
                new Product("Fridge", "Electronics", 10000)
        );
        Map<String, Integer> totalPriceByCategory = products2.collect(Collectors.groupingBy(Product::category, Collectors.summingInt(Product::price)));
        System.out.println(totalPriceByCategory);

        //5. Aggregation : Average of Products by Category
        Stream<Product> product3 = Stream.of(
                new Product("Laptop", "Electronics", 10000),
                new Product("TV", "Electronics", 10000),
                new Product("Sofa", "Furniture", 20000),
                new Product("Bed", "Furniture", 20000),
                new Product("Fridge", "Electronics", 10000)
        );

        Map<String, Double> averageOfProductsByCategory = product3.collect(Collectors.groupingBy(Product::category, Collectors.averagingDouble(Product::price)));
        System.out.println(averageOfProductsByCategory);

        //6. Aggregation : Counting of Products by Category
        Stream<Product> product4 = Stream.of(
                new Product("Laptop", "Electronics", 10000),
                new Product("TV", "Electronics", 10000),
                new Product("Sofa", "Furniture", 20000),
                new Product("Bed", "Furniture", 20000),
                new Product("Fridge", "Electronics", 10000)
        );

        Map<String, Long> countOfProductsByCategory = product4.collect(Collectors.groupingBy(Product::category, Collectors.counting()));
        System.out.println(countOfProductsByCategory);

        //7. Filtering : Products with price > 5000
        Stream<Product> product5 = Stream.of(
                new Product("Laptop", "Electronics", 10000),
                new Product("TV", "Electronics", 10000),
                new Product("Sofa", "Furniture", 20000),
                new Product("Bed", "Furniture", 20000),
                new Product("Fridge", "Electronics", 10000)
        );

        List<Product> filteredProducts = product5.filter(product -> product.price > 50000).collect(Collectors.toList());
        System.out.println(filteredProducts);

        //8. Extracting Product names
        Stream<Product> product6 = Stream.of(
                new Product("Laptop", "Electronics", 10000),
                new Product("TV", "Electronics", 10000),
                new Product("Sofa", "Furniture", 20000),
                new Product("Bed", "Furniture", 20000),
                new Product("Fridge", "Electronics", 10000)
        );
        List<String> extractProductCategories = product6.map(Product::category).collect(Collectors.toList());
        System.out.println(extractProductCategories);

        //9 Partitioning : Separate products into Expensive and Cheap
        Stream<Product> product7 = Stream.of(
                new Product("Laptop", "Electronics", 4000),
                new Product("TV", "Electronics", 2000),
                new Product("Sofa", "Furniture", 200),
                new Product("Bed", "Furniture", 25000),
                new Product("Fridge", "Electronics", 10000)
        );
        Map<Boolean, List<Product>> partitionedProducts = product7.collect(Collectors.partitioningBy(product -> product.price > 5000));
        System.out.println(partitionedProducts);

        //10 Using Summary statistics for Product Prices
        //Sum, average, min, max, count (5 metrics)
        Stream<Product> product8 = Stream.of(
                new Product("Laptop", "Electronics", 4000),
                new Product("TV", "Electronics", 2000),
                new Product("Sofa", "Furniture", 200),
                new Product("Bed", "Furniture", 25000),
                new Product("Fridge", "Electronics", 10000)
        );
        Map<String, IntSummaryStatistics> summary = product8.collect(Collectors.groupingBy(Product::category, Collectors.summarizingInt(Product::price)));
        System.out.println(summary);
    }
}
