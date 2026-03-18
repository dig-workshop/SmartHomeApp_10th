# SOLID Principles Workshop - Smart Home App

このリポジトリーは、**SOLID原則** を学ぶための講義用教材です。SOLID原則を適用し、設計品質を向上させるコードの実装を **TDD（テスト駆動開発）** で体験していただきます。

## 🔥 SOLIDとは？

SOLIDはオブジェクト指向設計の5つの基本原則を表します。これらの原則を守ることで、保守性や拡張性の高いコードを設計できます。

- **S** - Single Responsibility Principle（単一責任の原則）
  - クラスは単一の責任を持つべきです。
- **O** - Open/Closed Principle（開放/閉鎖の原則）
  - ソフトウェアは拡張に対して開かれ、変更に対して閉じているべきです。
- **L** - Liskov Substitution Principle（リスコフの置換原則）
  - サブクラスは、親クラスと置き換えても正しく動作すべきです。
- **I** - Interface Segregation Principle（インターフェース分離の原則）
  - クライアントは自身が使用しないメソッドに依存してはならない。
- **D** - Dependency Inversion Principle（依存関係逆転の原則）
  - 高水準モジュールは低水準モジュールに依存すべきではなく、両者は抽象に依存すべきです。

## 📝 今回の題材

以下のような **電球** と **スイッチ** が提供されているとします：

### B9000（電球）
- `turnOn()` を呼ぶと、オンになる。
- `turnOff()` を呼ぶと、オフになる。

### S9000（スイッチ）
- `isOn()`: 現在の状態がオンになっていれば `true` を返す。そうでなければ `false` を返す。

これらを使って、以下のアプリを **TDD** で開発します：

### Smart Home App
- 電球 (bulb) とスイッチ (switch) を繋げる。
- スイッチがオンされたら、電球をオンにする。
- スイッチがオフされたら、電球をオフにする。

## 🚀 課題の進め方

1. **テストを書く** — `SmartHomeAppTests.kt` に、期待する振る舞いをテストとして記述する
2. **テストが失敗することを確認する**（🔴 Red）
3. **最小限の実装を行う** — `SmartHomeApp.kt` にテストが通るコードを書く（🟢 Green）
4. **リファクタリングする** — コードを整理し、設計を改善する（🔵 Refactor）
5. **1〜4を繰り返す**

### 💡 チャレンジ問題
時間が余ったら、新しい家電を1つ追加してみましょう！（TV、エアコンなど）

## 📂 ディレクトリ構造

```
├── src/
│   ├── main/                      # メインコード
│   │   └── kotlin/
│   │       ├── pair/              # ペアプロ用 実装ファイル
│   │       │   └── SmartHomeApp.kt
│   │       │
│   │       └── example/           # 実装例（参考）
│   │           └── SmartHomeExample.kt
│   │
│   └── test/                      # テストコード
│       └── kotlin/
│           └── SmartHomeAppTests.kt
│
├── build.gradle.kts
├── settings.gradle.kts
└── gradlew
```

## 💻 環境構築と実行方法

### リポジトリーをクローン：
```bash
git clone https://github.com/dig-workshop/XPPPP_9th.git
cd XPPPP_9th
```

### 依存関係をインストール：
```bash
./gradlew dependencies
```

### テストの実行：
```bash
./gradlew test
```

