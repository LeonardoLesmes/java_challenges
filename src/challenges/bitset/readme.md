# BitSet Operations

Java's `BitSet` class implements a vector of bit values (i.e.: `false` (0) or `true` (1)) that grows as needed, allowing us to easily manipulate bits while optimizing space (when compared to other collections). Any element having a bit value of 1 is called a set bit.

Given 2 BitSets, **B₁** and **B₂**, of size **N** where all bits in both BitSets are initialized to 0, perform a series of **M** operations. After each operation, print the number of set bits in the respective BitSets as two space-separated integers on a new line.

---

## 📥 Input Format

The first line contains 2 space-separated integers, `N` (the length of both BitSets **B₁** and **B₂**) and `M` (the number of operations to perform), respectively.

The **M** subsequent lines each contain an operation in one of the following forms:

- `AND <set> <set>`
- `OR <set> <set>`
- `XOR <set> <set>`
- `FLIP <set> <index>`
- `SET <set> <index>`

---

### 📌 Notas:

- `<set>` is the integer `1` or `2`, where `1` denotes **B₁** and `2` denotes **B₂**.
- `<index>` is an integer denoting a bit's index in the BitSet corresponding to `<set>`.

---

### 🔁 Binary Operations (`AND`, `OR`, `XOR`)

Operands are read **from left to right** and the BitSet resulting from the operation replaces the contents of the **first operand**.

```text
AND 2 1
```

- **B₂** is the left operand, and **B₁** is the right operand.
- This operation should assign the result of `B₂ ∧ B₁` to **B₂**.

### 📃 Sample

**Input:**
```text
5 4
AND 1 2
SET 1 4
FLIP 2 2
OR 2 1
```

**Output:**
```text
0 0
1 0
1 1
1 2
```

From HackerRank: https://www.hackerrank.com/challenges/java-bitset/problem