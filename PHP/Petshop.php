<?php

class PetShop {
    private $products = [];

    public function __construct() {
        // Menambahkan produk secara statis
        $this->products = [
            [
                'id' => 1,
                'name' => 'Royal Canin Kitty',
                'category' => 'Makanan',
                'price' => 120000,
                'photo' => 'Royalcanin_Kitty.jpg' 
            ],
            [
                'id' => 2,
                'name' => 'Royal Canin Puppy',
                'category' => 'Makanan',
                'price' => 150000,
                'photo' => 'Royalcanin_Puppy.jpg' 
            ],
            [
                'id' => 3,
                'name' => 'Whiskas Wet',
                'category' => 'Makanan',
                'price' => 50000,
                'photo' => 'WhiskasWet.jpg' 
            ]
        ];
    }

    // Metode untuk mendapatkan produk
    public function get_products() {
        return $this->products;
    }

    // Metode untuk menampilkan semua produk
    public function display_products() {
        if (empty($this->products)) {
            echo "Tidak ada data produk.<br>";
            return;
        }
        echo "<h2>Daftar Produk:</h2>";
        foreach ($this->products as $product) {
            echo "Id: {$product['id']}<br>";
            echo "Nama: {$product['name']}<br>";
            echo "Kategori: {$product['category']}<br>";
            echo "Harga: Rp {$product['price']}<br>";
            echo "<img src='{$product['photo']}' alt='Foto Produk' style='width:100px;height:auto;'><br><br>";
        }
    }

    // Metode untuk menambahkan produk baru
    public function add_product($name, $category, $price, $photo) {
        $product_id = count($this->products) + 1;
        $new_product = [
            'id' => $product_id,
            'name' => $name,
            'category' => $category,
            'price' => $price,
            'photo' => $photo
        ];
        $this->products[] = $new_product;
        echo "Produk '{$name}' berhasil ditambahkan.<br><br>";
    }

    // Metode untuk memperbarui informasi produk/mengedit
    public function update_product($product_id, $name = null, $category = null, $price = null, $photo = null) {
        foreach ($this->products as &$product) {
            if ($product['id'] == $product_id) {
                if ($name !== null) {
                    $product['name'] = $name;
                }
                if ($category !== null) {
                    $product['category'] = $category;
                }
                if ($price !== null) {
                    $product['price'] = $price;
                }
                if ($photo !== null) {
                    $product['photo'] = $photo;
                }
                echo "Produk dengan ID {$product_id} berhasil diperbarui.<br><br>";
                return;
            }
        }
        echo "Produk dengan ID {$product_id} tidak ditemukan.<br>";
    }

    // Metode untuk menghapus produk berdasarkan ID
    public function delete_product($product_id) {
        foreach ($this->products as $key => $product) {
            if ($product['id'] == $product_id) {
                unset($this->products[$key]);
                echo "Produk dengan ID {$product_id} berhasil dihapus.<br><br>";
                return;
            }
        }
        echo "Produk dengan ID {$product_id} tidak ditemukan.<br>";
    }

    // Metode untuk mencari produk berdasarkan nama
    public function search_product($name) {
        $found_products = array_filter($this->products, function($product) use ($name) {
            return stripos($product['name'], $name) !== false;
        });
        if (empty($found_products)) {
            echo "Tidak ada produk yang ditemukan dengan nama '{$name}'.<br>";
            return;
        }
        echo "Produk yang ditemukan:<br><br>";
        foreach ($found_products as $product) {
            echo "Id: {$product['id']}<br>";
            echo "Nama: {$product['name']}<br>";
            echo "Kategori: {$product['category']}<br>";
            echo "Harga: Rp {$product['price']}<br>";
            echo "<img src='{$product['photo']}' alt='Foto Produk' style='width:100px;height:auto;'><br><br>";
        }
    }
}
?>