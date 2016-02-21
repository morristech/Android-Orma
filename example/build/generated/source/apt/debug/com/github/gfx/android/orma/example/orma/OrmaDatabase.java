package com.github.gfx.android.orma.example.orma;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import com.github.gfx.android.orma.DatabaseHandle;
import com.github.gfx.android.orma.Inserter;
import com.github.gfx.android.orma.ModelFactory;
import com.github.gfx.android.orma.OrmaConnection;
import com.github.gfx.android.orma.OrmaDatabaseBuilderBase;
import com.github.gfx.android.orma.Schema;
import com.github.gfx.android.orma.TransactionTask;
import com.github.gfx.android.orma.annotation.OnConflict;
import com.github.gfx.android.orma.exception.TransactionAbortException;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.List;

/**
 * The Orma database handle class.<br><br>
 * This is generated by {@code com.github.gfx.android.orma.processor.OrmaProcessor}
 */
public class OrmaDatabase implements DatabaseHandle {
  /**
   * The SHA-256 digest of all the {@code CREATE TABLE} and {@code CREATE INDEX} statements.
   */
  public static String SCHEMA_HASH = "415EFE25C7A15AE414AB7BFE6513008E335AE0E83A402AA465794101091364F7";

  public static final List<Schema<?>> SCHEMAS = Arrays.<Schema<?>>asList(
    Category_Schema.INSTANCE,
    Item_Schema.INSTANCE,
    Todo_Schema.INSTANCE
  );

  private final OrmaConnection connection;

  public OrmaDatabase(@NonNull OrmaConnection connection) {
    this.connection = connection;
  }

  public static Builder builder(@NonNull Context context) {
    return new Builder(context);
  }

  @NonNull
  @Override
  public List<Schema<?>> getSchemas() {
    return SCHEMAS;
  }

  /**
   * <p>{@code migrate()} invokes database migration, which will takes several seconds.</p>
   * <p>This is completely optional and migration is invoked on the first access of the database, anyway.</p>
   *
   * @throws SQLiteConstraintException migration information is not sufficient.
   */
  public void migrate() throws SQLiteConstraintException {
    connection.getWritableDatabase();
  }

  @NonNull
  @Override
  public OrmaConnection getConnection() {
    return connection;
  }

  @WorkerThread
  public void transactionSync(@NonNull TransactionTask task) throws TransactionAbortException {
    connection.transactionSync(task);
  }

  public void transactionAsync(@NonNull TransactionTask task) {
    connection.transactionAsync(task);
  }

  public void transactionNonExclusiveSync(@NonNull TransactionTask task) throws TransactionAbortException {
    connection.transactionNonExclusiveSync(task);
  }

  public void transactionNonExclusiveAsync(@NonNull TransactionTask task) {
    connection.transactionNonExclusiveAsync(task);
  }

  @NonNull
  public Category loadCategoryfromCursor(@NonNull Cursor cursor) {
    return Category_Schema.INSTANCE.newModelFromCursor(connection, cursor, 0);
  }

  /**
   * Inserts a model created by {@code ModelFactory<T>}, and retrieves it which is just inserted.
   *  The return value has the row ID.
   */
  @NonNull
  public Category createCategory(@NonNull ModelFactory<Category> factory) {
    return connection.createModel(Category_Schema.INSTANCE, factory);
  }

  /**
   * Creates a relation of {@code Category}, which is an entry point of all the operations.
   */
  @NonNull
  public Category_Relation relationOfCategory() {
    return new Category_Relation(connection, Category_Schema.INSTANCE);
  }

  /**
   * Starts building a query: {@code SELECT * FROM Category ...}.
   */
  @NonNull
  public Category_Selector selectFromCategory() {
    return new Category_Selector(connection, Category_Schema.INSTANCE);
  }

  /**
   * Starts building a query: {@code UPDATE Category ...}.
   */
  @NonNull
  public Category_Updater updateCategory() {
    return new Category_Updater(connection, Category_Schema.INSTANCE);
  }

  /**
   * Starts building a query: {@code DELETE FROM Category ...}.
   */
  @NonNull
  public Category_Deleter deleteFromCategory() {
    return new Category_Deleter(connection, Category_Schema.INSTANCE);
  }

  /**
   * Executes a query: {@code INSERT INTO Category ...}.
   */
  public long insertIntoCategory(@NonNull Category model) {
    return prepareInsertIntoCategory().execute(model);
  }

  /**
   * Create a prepared statement for {@code INSERT INTO Category ...}.
   */
  public Inserter<Category> prepareInsertIntoCategory() {
    return prepareInsertIntoCategory(OnConflict.NONE, true);
  }

  /**
   * Create a prepared statement for {@code INSERT OR ... INTO Category ...}.
   */
  public Inserter<Category> prepareInsertIntoCategory(@OnConflict int onConflictAlgorithm) {
    return prepareInsertIntoCategory(onConflictAlgorithm, true);
  }

  /**
   * Create a prepared statement for {@code INSERT OR ... INTO Category ...}.
   */
  public Inserter<Category> prepareInsertIntoCategory(@OnConflict int onConflictAlgorithm, boolean withoutAutoId) {
    return new Inserter<Category>(connection, Category_Schema.INSTANCE, onConflictAlgorithm, withoutAutoId);
  }

  @NonNull
  public Item loadItemfromCursor(@NonNull Cursor cursor) {
    return Item_Schema.INSTANCE.newModelFromCursor(connection, cursor, 0);
  }

  /**
   * Inserts a model created by {@code ModelFactory<T>}, and retrieves it which is just inserted.
   *  The return value has the row ID.
   */
  @NonNull
  public Item createItem(@NonNull ModelFactory<Item> factory) {
    return connection.createModel(Item_Schema.INSTANCE, factory);
  }

  /**
   * Creates a relation of {@code Item}, which is an entry point of all the operations.
   */
  @NonNull
  public Item_Relation relationOfItem() {
    return new Item_Relation(connection, Item_Schema.INSTANCE);
  }

  /**
   * Starts building a query: {@code SELECT * FROM Item ...}.
   */
  @NonNull
  public Item_Selector selectFromItem() {
    return new Item_Selector(connection, Item_Schema.INSTANCE);
  }

  /**
   * Starts building a query: {@code UPDATE Item ...}.
   */
  @NonNull
  public Item_Updater updateItem() {
    return new Item_Updater(connection, Item_Schema.INSTANCE);
  }

  /**
   * Starts building a query: {@code DELETE FROM Item ...}.
   */
  @NonNull
  public Item_Deleter deleteFromItem() {
    return new Item_Deleter(connection, Item_Schema.INSTANCE);
  }

  /**
   * Executes a query: {@code INSERT INTO Item ...}.
   */
  public long insertIntoItem(@NonNull Item model) {
    return prepareInsertIntoItem().execute(model);
  }

  /**
   * Create a prepared statement for {@code INSERT INTO Item ...}.
   */
  public Inserter<Item> prepareInsertIntoItem() {
    return prepareInsertIntoItem(OnConflict.NONE, true);
  }

  /**
   * Create a prepared statement for {@code INSERT OR ... INTO Item ...}.
   */
  public Inserter<Item> prepareInsertIntoItem(@OnConflict int onConflictAlgorithm) {
    return prepareInsertIntoItem(onConflictAlgorithm, true);
  }

  /**
   * Create a prepared statement for {@code INSERT OR ... INTO Item ...}.
   */
  public Inserter<Item> prepareInsertIntoItem(@OnConflict int onConflictAlgorithm, boolean withoutAutoId) {
    return new Inserter<Item>(connection, Item_Schema.INSTANCE, onConflictAlgorithm, withoutAutoId);
  }

  @NonNull
  public Todo loadTodofromCursor(@NonNull Cursor cursor) {
    return Todo_Schema.INSTANCE.newModelFromCursor(connection, cursor, 0);
  }

  /**
   * Inserts a model created by {@code ModelFactory<T>}, and retrieves it which is just inserted.
   *  The return value has the row ID.
   */
  @NonNull
  public Todo createTodo(@NonNull ModelFactory<Todo> factory) {
    return connection.createModel(Todo_Schema.INSTANCE, factory);
  }

  /**
   * Creates a relation of {@code Todo}, which is an entry point of all the operations.
   */
  @NonNull
  public Todo_Relation relationOfTodo() {
    return new Todo_Relation(connection, Todo_Schema.INSTANCE);
  }

  /**
   * Starts building a query: {@code SELECT * FROM Todo ...}.
   */
  @NonNull
  public Todo_Selector selectFromTodo() {
    return new Todo_Selector(connection, Todo_Schema.INSTANCE);
  }

  /**
   * Starts building a query: {@code UPDATE Todo ...}.
   */
  @NonNull
  public Todo_Updater updateTodo() {
    return new Todo_Updater(connection, Todo_Schema.INSTANCE);
  }

  /**
   * Starts building a query: {@code DELETE FROM Todo ...}.
   */
  @NonNull
  public Todo_Deleter deleteFromTodo() {
    return new Todo_Deleter(connection, Todo_Schema.INSTANCE);
  }

  /**
   * Executes a query: {@code INSERT INTO Todo ...}.
   */
  public long insertIntoTodo(@NonNull Todo model) {
    return prepareInsertIntoTodo().execute(model);
  }

  /**
   * Create a prepared statement for {@code INSERT INTO Todo ...}.
   */
  public Inserter<Todo> prepareInsertIntoTodo() {
    return prepareInsertIntoTodo(OnConflict.NONE, true);
  }

  /**
   * Create a prepared statement for {@code INSERT OR ... INTO Todo ...}.
   */
  public Inserter<Todo> prepareInsertIntoTodo(@OnConflict int onConflictAlgorithm) {
    return prepareInsertIntoTodo(onConflictAlgorithm, true);
  }

  /**
   * Create a prepared statement for {@code INSERT OR ... INTO Todo ...}.
   */
  public Inserter<Todo> prepareInsertIntoTodo(@OnConflict int onConflictAlgorithm, boolean withoutAutoId) {
    return new Inserter<Todo>(connection, Todo_Schema.INSTANCE, onConflictAlgorithm, withoutAutoId);
  }

  public static class Builder extends OrmaDatabaseBuilderBase<Builder> {
    public Builder(@NonNull Context context) {
      super(context);
    }

    @NonNull
    @Override
    protected String getSchemaHash() {
      return SCHEMA_HASH;
    }

    public OrmaDatabase build() {
      return new OrmaDatabase(new OrmaConnection(fillDefaults(), SCHEMAS));
    }
  }
}
