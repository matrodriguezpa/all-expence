package matrodriguezpa.allexpence.model;

import jakarta.persistence.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import lombok.*;
import java.util.ArrayList;
import java.util.List;
import matrodriguezpa.allexpence.dao.ProjectDAO;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private int year;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Month> month = new ArrayList<>();

    /**
     * Validates that the project name is non-empty and contains only letters
     * and spaces.
     *
     * @param name
     * @return
     */
    public static boolean isValidName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (name.matches("[A-Za-zÁÉÍÓÚáéíóúÑñ ]+")) {
            return true;
        }
        throw new IllegalArgumentException("Invalid input");
    }

    /**
     * Parses and validates year (0–9999).
     *
     * @param yearText
     * @return
     * @throws IllegalArgumentException if invalid.
     */
    public static void isEmpty(String yearText) {
        if (yearText == null || yearText.trim().isEmpty()) {
            throw new IllegalArgumentException("Year cannot be empty");
        }
    }

    public static int validateYear(String yearText) {
        int y;
        try {
            y = Integer.parseInt(yearText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Please enter a valid number");
        }
        if (y < 0 || y > 9999) {
            throw new IllegalArgumentException("Year must be between 0 and 9999");
        }
        return y;
    }

    /**
     * Adds a month column to this project.
     *
     * @param month 1–12
     * @throws IllegalArgumentException if month out of range
     * @throws SQLException on DB error
     */
    public void addMonth(int month) throws SQLException {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month number.");
        }
        String column = "month_" + month;
        String sql = "UPDATE projects SET " + column + " = ? WHERE id = ?";
        ProjectDAO dao = new ProjectDAO();
        //dao.updateMonthBudget(sql, 1, this.id);
    }

    /**
     * Returns a list of active months for this project (e.g. ["1", "3", ...]).
     *
     * @param rs
     * @return
     * @throws java.sql.SQLException
     */
    public List<String> getActiveMonths(ResultSet rs) throws SQLException {
        List<String> months = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            String val = rs.getString("month_" + i);
            if (val != null) {
                months.add(String.valueOf(i));
            }
        }
        return months;
    }
}
