package matrodriguezpa.allexpence.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Expense {

    @Id
    private Long id;
    
    private int YEAR;
    
    private int MONTH;
    
    private int DAY;
    // ideally LocalDate
    
    private String company;
    
    private double amount;
    
    private String type;
    
    private String matrix;
    
    private String payment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "month_id", nullable = false)
    private Month month;

    /**
     * Validates that the date is in valid day/month range.
     *
     * @param day
     * @param month
     * @throws IllegalArgumentException if invalid date
     */
    public static void validateDate(int month, int day) {
        if (month == 2 && day > 29) {
            throw new IllegalArgumentException("Invalid date: February cannot have more than 29 days.");
        }
        if (day < 1 || day > 31 || month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid date");
        }
    }

    /**
     * Validates that the amount is non-negative.
     *
     * @param amt
     * @throws IllegalArgumentException if amount < 0
     */
    public static void validateAmount(double amt) {
        if (amt < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }
    }
}
