import os
import re

target_extensions = ['.java']

def convert_swagger_annotations(file_path):
    with open(file_path, 'r', encoding='utf-8') as file:
        content = file.read()

    # 只轉換有舊 Swagger 註解的檔案
    if "ApiModelProperty" not in content:
        return

    print(f"🔄 轉換中: {file_path}")

    # 1. 替換 import
    content = content.replace(
        'import io.swagger.annotations.ApiModelProperty;',
        'import io.swagger.v3.oas.annotations.media.Schema;'
    )

    # 2. 替換 @ApiModelProperty(value = "...")
    content = re.sub(
        r'@ApiModelProperty\s*\(\s*value\s*=\s*"([^"]+)"\s*\)',
        r'@Schema(description = "\1")',
        content
    )

    with open(file_path, 'w', encoding='utf-8') as file:
        file.write(content)

def walk_directory(root_dir):
    for foldername, _, filenames in os.walk(root_dir):
        for filename in filenames:
            if any(filename.lower().endswith(ext) for ext in target_extensions):
                filepath = os.path.join(foldername, filename)
                try:
                    convert_swagger_annotations(filepath)
                except Exception as e:
                    print(f"❌ 錯誤處理檔案 {filepath}: {e}")

if __name__ == '__main__':
    current_dir = os.path.dirname(os.path.abspath(__file__))
    walk_directory(current_dir)
    print("✅ 所有 Java 檔案轉換完成")