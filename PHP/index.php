<?php
require_once 'Petshop.php'; // Mengimpor kelas PetShop

// Membuat instance dari PetShop
$petshop = new PetShop();

// Menambahkan produk baru
$petshop->add_product('Tempat Tidur Hewan', 'Barang', 200000, 'Tempattidur.png'); 

// Memperbarui produk bedasarkan id
$petshop->update_product(2, 'Box Hewan', 'Barang', 160000, 'BoxHewan.jpg'); 

// Menghapus produk bedasarkan id
$petshop->delete_product(4); 

// Mencari produk bedasarkan nama
$petshop->search_product('canin'); 

// Menampilkan produk
?>
<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pet Shop</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h2 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        img {
            width: 100px;
            height: auto;
        }
    </style>
</head>
<body>
    <h2>Daftar Produk:</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Nama</th>
            <th>Kategori</th>
            <th>Harga</th>
            <th>Foto</th>
        </tr>
        <?php
        // Menampilkan produk dalam tabel
        foreach ($petshop->get_products() as $product) {
            echo "<tr>";
            echo "<td>{$product['id']}</td>";
            echo "<td>{$product['name']}</td>";
            echo "<td>{$product['category']}</td>";
            echo "<td>Rp {$product['price']}</td>";
            echo "<td><img src='{$product['photo']}' alt='Foto Produk'></td>";
            echo "</tr>";
        }
        ?>
    </table>
</body>
</html>