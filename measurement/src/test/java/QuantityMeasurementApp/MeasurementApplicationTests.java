package QuantityMeasurementApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MeasurementApplicationTests {

    // ================= UC1: Feet =================

    @Test
    void testFeetEquality_SameValue() {
        MeasurementApplication.Feet f1 = new MeasurementApplication.Feet(89.6);
        MeasurementApplication.Feet f2 = new MeasurementApplication.Feet(89.6);
        Assertions.assertEquals(f1, f2);
    }

    @Test
    void testFeetInEquality_DifferentValue() {
        MeasurementApplication.Feet f1 = new MeasurementApplication.Feet(89.6);
        MeasurementApplication.Feet f2 = new MeasurementApplication.Feet(34.6);
        Assertions.assertNotEquals(f1, f2);
    }

    @Test
    void testFeetEquality_NullComparison() {
        MeasurementApplication.Feet f1 = new MeasurementApplication.Feet(55.0);
        Assertions.assertFalse(f1.equals(null));
    }

    @Test
    void testFeetEquality_DifferentType() {
        MeasurementApplication.Feet f1 = new MeasurementApplication.Feet(89.0);
        Assertions.assertFalse(f1.equals("Some String"));
    }

    @Test
    void testFeetEquality_SameReference() {
        MeasurementApplication.Feet f1 = new MeasurementApplication.Feet(89.0);
        Assertions.assertTrue(f1.equals(f1));
    }

    // ================= UC2: Inches =================

    @Test
    void testInchesEquality_SameValue() {
        MeasurementApplication.Inches i1 = new MeasurementApplication.Inches(10.0);
        MeasurementApplication.Inches i2 = new MeasurementApplication.Inches(10.0);
        Assertions.assertEquals(i1, i2);
    }

    @Test
    void testInchesInEquality_DifferentValue() {
        MeasurementApplication.Inches i1 = new MeasurementApplication.Inches(10.0);
        MeasurementApplication.Inches i2 = new MeasurementApplication.Inches(20.0);
        Assertions.assertNotEquals(i1, i2);
    }

    @Test
    void testInchesEquality_NullComparison() {
        MeasurementApplication.Inches i1 = new MeasurementApplication.Inches(10.0);
        Assertions.assertFalse(i1.equals(null));
    }

    @Test
    void testInchesEquality_DifferentType() {
        MeasurementApplication.Inches i1 = new MeasurementApplication.Inches(10.0);
        Assertions.assertFalse(i1.equals(100));
    }

    @Test
    void testInchesEquality_SameReference() {
        MeasurementApplication.Inches i1 = new MeasurementApplication.Inches(10.0);
        Assertions.assertTrue(i1.equals(i1));
    }

    // ================= UC3: QuantityLength =================

    @Test
    void testEquality_FeetToFeet_SameValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);

        Assertions.assertEquals(q1, q2);
    }

    @Test
    void testEquality_InchToInch_SameValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCHES);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCHES);

        Assertions.assertEquals(q1, q2);
    }

    @Test
    void testEquality_FeetToInch_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        Assertions.assertEquals(q1, q2);
    }

    @Test
    void testEquality_InchToFeet_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);

        Assertions.assertEquals(q1, q2);
    }

    @Test
    void testEquality_FeetToFeet_DifferentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.FEET);

        Assertions.assertNotEquals(q1, q2);
    }

    @Test
    void testEquality_InchToInch_DifferentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCHES);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.INCHES);

        Assertions.assertNotEquals(q1, q2);
    }

    @Test
    void testEquality_SameReference() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        Assertions.assertTrue(q1.equals(q1));
    }

    @Test
    void testEquality_NullComparison() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        Assertions.assertFalse(q1.equals(null));
    }

    @Test
    void testEquality_NullUnit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new QuantityLength(1.0, null);
        });
    }

    // ================= UC4: Extended Units =================

   @Test
		void testEquality_YardToYard_SameValue() {
			assertEquals(
					new QuantityLength(1.0, LengthUnit.YARDS),
					new QuantityLength(1.0, LengthUnit.YARDS)
			);
		}

		// 2
		@Test
		void testEquality_YardToYard_DifferentValue() {
			assertNotEquals(
					new QuantityLength(1.0, LengthUnit.YARDS),
					new QuantityLength(2.0, LengthUnit.YARDS)
			);
		}

		// 3
		@Test
		void testEquality_YardToFeet_EquivalentValue() {
			assertEquals(
					new QuantityLength(1.0, LengthUnit.YARDS),
					new QuantityLength(3.0, LengthUnit.FEET)
			);
		}

		// 4
		@Test
		void testEquality_FeetToYard_EquivalentValue() {
			assertEquals(
					new QuantityLength(3.0, LengthUnit.FEET),
					new QuantityLength(1.0, LengthUnit.YARDS)
			);
		}

		// 5
		@Test
		void testEquality_YardToInches_EquivalentValue() {
			assertEquals(
					new QuantityLength(1.0, LengthUnit.YARDS),
					new QuantityLength(36.0, LengthUnit.INCHES)
			);
		}

		// 6
		@Test
		void testEquality_InchesToYard_EquivalentValue() {
			assertEquals(
					new QuantityLength(36.0, LengthUnit.INCHES),
					new QuantityLength(1.0, LengthUnit.YARDS)
			);
		}

		// 7
		@Test
		void testEquality_YardToFeet_NonEquivalentValue() {
			assertNotEquals(
					new QuantityLength(1.0, LengthUnit.YARDS),
					new QuantityLength(2.0, LengthUnit.FEET)
			);
		}

		// 8
		@Test
		void testEquality_CentimetersToInches_EquivalentValue() {
			assertEquals(
					new QuantityLength(1.0, LengthUnit.CENTIMETERS),
					new QuantityLength(0.393701, LengthUnit.INCHES)
			);
		}

		// 9
		@Test
		void testEquality_CentimetersToFeet_NonEquivalentValue() {
			assertNotEquals(
					new QuantityLength(1.0, LengthUnit.CENTIMETERS),
					new QuantityLength(1.0, LengthUnit.FEET)
			);
		}

		// 10 (Transitive property)
		@Test
		void testEquality_MultiUnit_TransitiveProperty() {
			QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARDS);
			QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);
			QuantityLength inch = new QuantityLength(36.0, LengthUnit.INCHES);

			assertEquals(yard, feet);
			assertEquals(feet, inch);
			assertEquals(yard, inch);
		}

		// 11
		@Test
       void testEquality_YardwithNullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
        new QuantityLength(1.0, null); // ✅ FIXED
    });
}

		// 12 (Reflexive)
		@Test
		void testEquality_YardSameReference() {
			QuantityLength q = new QuantityLength(1.0, LengthUnit.YARDS);
			assertEquals(q, q);
		}

		// 13
		@Test
		void testEquality_YardNullComparison() {
			QuantityLength q = new QuantityLength(1.0, LengthUnit.YARDS);
			assertNotEquals(q, null);
		}

		// 14
		@Test
		void testEquality_CentimetersWithNullUnit() {
			assertThrows(IllegalArgumentException.class, () -> {
				new QuantityLength(1.0, null);
			});
		}

		// 15 (Reflexive)
		@Test
		void testEquality_CentimetersSameReference() {
			QuantityLength q = new QuantityLength(1.0, LengthUnit.CENTIMETERS);
			assertEquals(q, q);
		}

		// 16
		@Test
		void testEquality_CentimetersNullComparison() {
			QuantityLength q = new QuantityLength(1.0, LengthUnit.CENTIMETERS);
			assertNotEquals(q, null);
		}

		// 17 (Complex multi-unit)
		@Test
		void testEquality_AllUnits_ComplexScenario() {
			QuantityLength yard = new QuantityLength(2.0, LengthUnit.YARDS);
			QuantityLength feet = new QuantityLength(6.0, LengthUnit.FEET);
			QuantityLength inch = new QuantityLength(72.0, LengthUnit.INCHES);

			assertEquals(yard, feet);
			assertEquals(feet, inch);
			assertEquals(yard, inch);
		}

}